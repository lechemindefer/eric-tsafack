package eric.springframework.erictsafack.web.service;

import eric.springframework.erictsafack.web.model.CustomerDto;
import eric.springframework.erictsafack.web.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
public class CustomerServiceImpl implements CustomerService {
    @Override
    public CustomerDto findByCustomerId(UUID customerId) {
        return CustomerDto.builder().id(UUID.randomUUID())
                .CustomerName("Mariana Tex")
                .build();
    }

    @Override
    public CustomerDto saveCustomer(CustomerDto customerDto) {
        return CustomerDto.builder()
                .id(UUID.randomUUID())
                .build();
    }

    @Override
    public void customerUpdate(UUID customerId, CustomerDto customerDto) {
        log.debug("updating .....");
    }

    @Override
    public void deleteByCutomerId(UUID customerId) {
        log.debug("deleting a customer");
    }
}
