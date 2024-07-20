package monkey.luffy.accounts.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import monkey.luffy.accounts.entity.Account;

public interface AccountRepository extends JpaRepository<Account,Integer> {
    
}
