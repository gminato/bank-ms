package monkey.luffy.accounts.entity;

import java.util.Date;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.Id;
import lombok.Data;
import monkey.luffy.accounts.audit.AuditAwareImpl;

@Entity
@Data
@EntityListeners(AuditAwareImpl.class)
public class Account {
    @Id
    private Integer accountNumber;

    private int customerId;
    private String accountType;
    private String branchAddress;
    @CreatedDate 
    private Date createdAt;
    @CreatedBy
    private String createdBy;
    @LastModifiedDate
    private Date updatedAt;
    @LastModifiedBy
    private String updatedBy;

    // Getters and setters
}
