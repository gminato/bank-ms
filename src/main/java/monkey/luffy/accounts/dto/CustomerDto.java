package monkey.luffy.accounts.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CustomerDto {
    @NotEmpty
    @Size(min = 5,max = 30)
    private String name;
    @NotEmpty
    @Email
    private String email;
    @NotEmpty
    private String mobileNumber; 
    private AccountsDto accountsDto;
}
