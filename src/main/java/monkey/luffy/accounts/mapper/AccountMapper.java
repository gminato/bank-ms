package monkey.luffy.accounts.mapper;

import monkey.luffy.accounts.dto.AccountsDto;
import monkey.luffy.accounts.entity.Account;

public class AccountMapper {

    public static AccountsDto mapToAccountsDto(Account accounts,AccountsDto accountsDto) {
        accountsDto.setAccountNumber(accounts.getAccountNumber());
        accountsDto.setAccountType(accounts.getAccountType());
        accountsDto.setBranchAddress(accounts.getBranchAddress());

        return accountsDto;
    }

    public static Account mapToAccount(Account account,AccountsDto accountsDto) {
        account.setAccountNumber(accountsDto.getAccountNumber());
        account.setAccountType(accountsDto.getAccountType());
        account.setBranchAddress(accountsDto.getBranchAddress());
        return account;
    }

}
