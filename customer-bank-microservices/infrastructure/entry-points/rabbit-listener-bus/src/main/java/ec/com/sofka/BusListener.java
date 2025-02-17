package ec.com.sofka;

import ec.com.sofka.Customer;
import ec.com.sofka.data.CustomerInfoRecord;
import ec.com.sofka.data.CustomerInfoRequestRecord;
import ec.com.sofka.gateway.IBusMessageListener;
import ec.com.sofka.usecases.GetCustomerByIdUseCase;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.sql.SQLOutput;

@Service
public class BusListener implements IBusMessageListener {
    private final GetCustomerByIdUseCase getCustomerByIdUseCase;

    @Value("${app.queue_name}")
    private String queueName;

    public BusListener(GetCustomerByIdUseCase getCustomerByIdUseCase) {
        this.getCustomerByIdUseCase = getCustomerByIdUseCase;
    }

    @Override
    @RabbitListener(queues = "${app.queue_name}")
    public Object receiveMessage(CustomerInfoRequestRecord request) {
        System.out.println("Received message: " + request);

        try {
            Customer customer = getCustomerByIdUseCase.execute(request.identification());
            return !request.isInfo() ?
                    customer.getIdCustomer():
                    new CustomerInfoRecord(customer.getIdCustomer(), customer.getName());

        }catch (Exception ex){
            System.out.println("Error"+ ex);
            return "";
        }
    }
}
