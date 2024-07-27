package monkey.luffy.accounts.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.Date;


@Entity
@Data
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer customerId;

    private String name;
    private String email;
    private String mobileNumber;
    private Date createdAt;
    private String createdBy;
    private Date updatedAt;
    private String updatedBy;
    // private AccountsDto accountsDto; 

}
