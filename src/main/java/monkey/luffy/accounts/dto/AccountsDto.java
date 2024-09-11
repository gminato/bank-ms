package monkey.luffy.accounts.dto;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class AccountsDto {
    @NotEmpty
    @Pattern(regexp = "^[0-9]{10}$", message = "Account number should be 10 digits")
    private int accountNumber;
    @NotEmpty(message = "Account type is required")
    private String accountType;
    @NotEmpty(message = "Branch address is required")
    private String branchAddress;
}
