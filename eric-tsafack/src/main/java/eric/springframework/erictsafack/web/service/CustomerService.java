package eric.springframework.erictsafack.web.service;

import eric.springframework.erictsafack.web.model.CustomerDto;

import java.util.UUID;

public interface CustomerService {
    CustomerDto findByCustomerId(UUID customerId);

    CustomerDto saveCustomer(CustomerDto customerDto);

    void customerUpdate(UUID customerId, CustomerDto customerDto);

    void deleteByCutomerId(UUID customerId);
}
