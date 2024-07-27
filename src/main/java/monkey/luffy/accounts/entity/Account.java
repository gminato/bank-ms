package monkey.luffy.accounts.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Account {
    @Id
    private Integer accountNumber;

    private int customerId;
    private String accountType;
    private String branchAddress;
    private Date createdAt;
    private String createdBy;
    private Date updatedAt;
    private String updatedBy;

    // Getters and setters
}
