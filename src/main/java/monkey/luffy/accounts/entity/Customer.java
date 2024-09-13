package monkey.luffy.accounts.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import monkey.luffy.accounts.audit.AuditAwareImpl;

import java.util.Date;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

@Entity
@Data
@EntityListeners(AuditAwareImpl.class)
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer customerId;

    private String name;
    private String email;
    private String mobileNumber;
    @CreatedDate
    private Date createdAt;
    @CreatedBy
    private String createdBy;
    @LastModifiedDate
    private Date updatedAt;
    @LastModifiedBy
    private String updatedBy;

}
