package monkey.luffy.accounts.service;

import monkey.luffy.accounts.dto.CustomerDto;

public interface IAccountService { 
    /**
     * 
     * @param customerDto - CustomerDto Object/**
     */
    void createAccount(CustomerDto customerDto);

    CustomerDto findByMobileNumber(String mobileNumber);
}
