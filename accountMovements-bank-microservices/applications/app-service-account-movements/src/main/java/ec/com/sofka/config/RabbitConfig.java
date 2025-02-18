package ec.com.sofka.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {
    @Value("${app.exchange_name}")
    private String exchangeName;

    @Value("${app.queue_name}")
    private String queueName;

    @Value("${app.routing_key}")
    private String routingKey;

    @Bean
    public TopicExchange customerExchange() {
        return new TopicExchange(exchangeName, true, false);
    }

    @Bean
    public Queue customerQueue() {
        return new Queue(queueName, true);
    }

    @Bean
    public Binding accountBinding() {
        return BindingBuilder.bind(customerQueue())
                .to(customerExchange())
                .with(routingKey);
    }

    @Bean
    public ApplicationListener<ApplicationReadyEvent> initializeBeans(AmqpAdmin amqpAdmin) {
        return event -> {


            amqpAdmin.declareExchange(customerExchange());
            amqpAdmin.declareQueue(customerQueue());
            amqpAdmin.declareBinding(accountBinding());
        };
    }

    @Bean
    public MessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public AmqpTemplate rabbitTemplateBean(ConnectionFactory connectionFactory) {
        final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(jsonMessageConverter());
        return rabbitTemplate;
    }
}
