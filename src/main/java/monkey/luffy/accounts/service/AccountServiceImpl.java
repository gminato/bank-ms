package monkey.luffy.accounts.service;

import java.util.Date;
import java.util.Optional;
import java.util.Random;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import monkey.luffy.accounts.dto.AccountsDto;
import monkey.luffy.accounts.dto.CustomerDto;
import monkey.luffy.accounts.entity.Account;
import monkey.luffy.accounts.entity.Customer;
import monkey.luffy.accounts.exceptions.CustomerAlreadyExistsException;
import monkey.luffy.accounts.exceptions.ResourceNotFoundClassException;
import monkey.luffy.accounts.mapper.AccountMapper;
import monkey.luffy.accounts.mapper.CustomerMapper;
import monkey.luffy.accounts.repository.AccountRepository;
import monkey.luffy.accounts.repository.CustomerRepository;

@Service
@AllArgsConstructor
public class AccountServiceImpl implements IAccountService {

    private AccountRepository accountRepository;
    private CustomerRepository customerRepository;

    /**
     * @param customerDto - CustomerDto Object
     */
    @Override
    public void createAccount(CustomerDto customerDto) {
        Optional<Customer> optionalCustomer=customerRepository.findByMobileNumber(
            customerDto.getMobileNumber()
            );
        System.out.println(customerRepository.findAll());
        if(optionalCustomer.isPresent()) {
            throw new CustomerAlreadyExistsException("Customer already register with mobile number" + customerDto.getMobileNumber());
        }
        Customer customer = CustomerMapper.mapToCustomer(customerDto, new Customer());
        Customer savedCustomer =  customerRepository.save(customer);
        accountRepository.save(createNewAccount(savedCustomer));
    }

    private Account createNewAccount(Customer customer) {
        Account newAccount = new Account();
        newAccount.setCustomerId(customer.getCustomerId());
        newAccount.setAccountNumber(new Random().nextInt(9000000));
        newAccount.setAccountType("saving");
        newAccount.setBranchAddress("test address");
        newAccount.setCreatedAt(new Date());
        return newAccount;
    }

    @Override
    public CustomerDto findByMobileNumber(String mobileNumber) {
        Customer customer = customerRepository.findByMobileNumber(mobileNumber).orElseThrow(
            () -> new ResourceNotFoundClassException("customer","mobile number", mobileNumber)
        );
        Account account = accountRepository.findByCustomerId(customer.getCustomerId()).orElseThrow(
            () -> new ResourceNotFoundClassException("account","customer id ","customerID")
        );
        CustomerDto customerDto = CustomerMapper.mapToCustomerDto(customer,new CustomerDto());
        AccountsDto accountsDto =AccountMapper.mapToAccountsDto(account,new AccountsDto());
        customerDto.setAccountsDto(accountsDto);

        return customerDto; 
    }
    
}
