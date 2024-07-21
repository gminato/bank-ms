package monkey.luffy.accounts.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
@Data {
        
    }
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int accountNumber;

    private int customerId;
    private String accountType;
    private String branchAddress;
    private Date createdAt;
    private String createdBy;
    private Date updatedAt;
    private String updatedBy;

    // Getters and setters
}
