package ec.com.sofka;
import ec.com.sofka.data.CustomerInfoRecord;
import ec.com.sofka.data.CustomerInfoRequestRecord;
import ec.com.sofka.gateway.IBusMessage;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.LinkedHashMap;

@Service
public class BusAdapter implements IBusMessage {
    private  final RabbitTemplate rabbitTemplate;

    @Value("${app.exchange_name}")
    private String exchangeName;

    @Value("${app.routing_key}")
    private String routingKey;

    public BusAdapter(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Override
    public Object sendMessage(CustomerInfoRequestRecord request) {
        Object response = rabbitTemplate.convertSendAndReceive(
               exchangeName,
               routingKey,
                request
        );

        System.out.println(response);

        if (response != null) {
            System.out.println(response.getClass().getName());

            if (response instanceof String) {
                return response.toString();
            }
            if (response instanceof LinkedHashMap) {
                ObjectMapper objectMapper = new ObjectMapper();
                return objectMapper.convertValue(response, CustomerInfoRecord.class);
            }

            if (response instanceof CustomerInfoRecord) {
                return response;
            }
        }
        return null;
    }
}
