package monkey.luffy.accounts.controller;

import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import monkey.luffy.accounts.dto.CustomerDto;
import monkey.luffy.accounts.dto.ResponseDto;
import monkey.luffy.accounts.service.IAccountService;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
@RequestMapping(path = "/api/account",produces = {MediaType.APPLICATION_JSON_VALUE})
@AllArgsConstructor
@Validated
public class AccountsController {

    private final IAccountService iAccountService;

    @PostMapping("/create")
    public ResponseEntity<ResponseDto> createAccount(@Valid @RequestBody CustomerDto customerDto) {
        iAccountService.createAccount(customerDto);
        return ResponseEntity.status(HttpStatus.CREATED)
        .body(new ResponseDto("201","Record created successfully"));
    }

    @GetMapping("/fetch")
    public ResponseEntity<CustomerDto> fetchAccountDetails(@RequestParam(name="mobilenum")
    @Pattern(regexp = "^[0-9]{10}$", message = "Mobile number should be 10 digit")
    String mobileNumber){
        CustomerDto customerDto = iAccountService.findByMobileNumber(mobileNumber);
        return ResponseEntity.status(HttpStatus.OK)
        .body(customerDto);
    }
       
    @PutMapping("/update")
    public ResponseEntity<ResponseDto> updateAccountDetail(@Valid @RequestBody CustomerDto customerDto) {
        boolean isUpdated = iAccountService.updateAccountDetail(customerDto);
        if(isUpdated) {
            return ResponseEntity.status(HttpStatus.OK)
            .body(new ResponseDto("200","Updated account successfully"));
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
            .body(new ResponseDto("500","Error in creating account contact dev"));
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<ResponseDto> deleteCustomerAndAccount(@Valid @RequestParam(name="mobilenum")
    @Pattern(regexp = "^[0-9]{10}$", message = "Mobile number should be 10 digit") 
    String mobileNumber) {
        boolean deleteAccountSuccess = iAccountService.deleteAccount(mobileNumber);
        if(deleteAccountSuccess) {
            return ResponseEntity.status(HttpStatus.OK)
            .body(new ResponseDto("200","Deleted account successfully"));
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
            .body(new ResponseDto("500","Error in deleting this account contact to helpline"));
        }
    }
   
}
