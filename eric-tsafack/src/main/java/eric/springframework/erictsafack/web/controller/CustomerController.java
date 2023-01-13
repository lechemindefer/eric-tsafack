package eric.springframework.erictsafack.web.controller;

import eric.springframework.erictsafack.web.model.CustomerDto;
import eric.springframework.erictsafack.web.service.CustomerService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1")
public class CustomerController {

    private CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/customer/{customerId}")
    public ResponseEntity<CustomerDto> getCustomer(@PathVariable UUID customerId){
        return new ResponseEntity<>(customerService.findByCustomerId(customerId), HttpStatus.OK);
    }

    @PostMapping("customer/create")
    public ResponseEntity<CustomerDto> createCustomer(@RequestBody CustomerDto customerDto){
        CustomerDto saveCustomer = customerService.saveCustomer(customerDto);

        HttpHeaders headers = new HttpHeaders();
        headers.add("location", saveCustomer.getId().toString());

        return new ResponseEntity<>(headers,HttpStatus.CREATED);
    }
    @PutMapping("customer/{beerId}")
    public ResponseEntity<CustomerDto> updateCustomer(@PathVariable UUID customerId, @RequestBody CustomerDto customerDto){
        customerService.customerUpdate(customerId,customerDto);
        return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("customer/{customerId}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteCustomer(@PathVariable UUID customerId){
        customerService.deleteByCutomerId(customerId);
    }
}
