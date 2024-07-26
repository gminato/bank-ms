package monkey.luffy.accounts.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import monkey.luffy.accounts.entity.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account,Integer> {
    Optional<Account> findByCustomerId(int customerId);
}
