package monkey.luffy.accounts.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CustomerDto {
    @NotEmpty(message = "Name is required")
    @Size(min = 5,max = 30)
    private String name;
    @NotEmpty(message = "Email is required")
    @Email
    private String email;
    @NotEmpty
    @Pattern(regexp = "^[0-9]{10}$", message = "Mobile number should be 10 digits")
    private String mobileNumber; 
    private AccountsDto accountsDto;
}
