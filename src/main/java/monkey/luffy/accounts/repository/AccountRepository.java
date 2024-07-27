package monkey.luffy.accounts.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import jakarta.transaction.Transactional;
import monkey.luffy.accounts.entity.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account,Integer> {
    Optional<Account> findByCustomerId(Integer customerId);

    @Transactional
    @Modifying
    void deleteByCustomerId(Integer customerId);
}
