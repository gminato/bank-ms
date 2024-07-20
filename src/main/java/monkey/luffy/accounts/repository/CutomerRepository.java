package monkey.luffy.accounts.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import monkey.luffy.accounts.entity.Customer;

public interface CutomerRepository extends JpaRepository<Customer,Integer> {
    
}
