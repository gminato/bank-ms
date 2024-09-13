package monkey.luffy.accounts.mapper;

import java.util.Date;

import monkey.luffy.accounts.dto.CustomerDto;
import monkey.luffy.accounts.entity.Customer;

public class CustomerMapper {

    public static CustomerDto mapToCustomerDto(Customer customer, CustomerDto customerDto) {
        customerDto.setName(customer.getName());
        customerDto.setEmail(customer.getEmail());
        customerDto.setMobileNumber(customer.getMobileNumber());
        return customerDto;
    }

    public static Customer mapToCustomer(CustomerDto customerDto, Customer customer) {
        customer.setName(customerDto.getName());
        customer.setEmail(customerDto.getEmail());
        customer.setMobileNumber(customerDto.getMobileNumber());
        customer.setCreatedAt(new Date());
        customer.setUpdatedAt(new Date());
        customer.setCreatedBy("system");
        // 12 digit random number
        // customer.setCustomerId((int) (Math.random() * 1000000000000L));
        return customer;
    }

}
