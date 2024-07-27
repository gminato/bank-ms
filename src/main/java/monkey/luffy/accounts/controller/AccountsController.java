package monkey.luffy.accounts.controller;

import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import monkey.luffy.accounts.dto.CustomerDto;
import monkey.luffy.accounts.dto.ResponseDto;
import monkey.luffy.accounts.service.IAccountService;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
@RequestMapping(path = "/api/account",produces = {MediaType.APPLICATION_JSON_VALUE})
@AllArgsConstructor
public class AccountsController {

    private final IAccountService iAccountService;

    @PostMapping("/create")
    public ResponseEntity<ResponseDto> createAccount(@RequestBody CustomerDto customerDto) {
        iAccountService.createAccount(customerDto);
        return ResponseEntity.status(HttpStatus.CREATED)
        .body(new ResponseDto("201","Record created successfully"));
    }

    @GetMapping("/fetch")
    public ResponseEntity<CustomerDto> fetchAccountDetails(@RequestParam(name="mobilenum") String mobileNumber){
        CustomerDto customerDto = iAccountService.findByMobileNumber(mobileNumber);
        return ResponseEntity.status(HttpStatus.OK)
        .body(customerDto);
    }
       
    @PutMapping("/update")
    public ResponseEntity<ResponseDto> updateAccountDetail(@RequestBody CustomerDto customerDto) {
        boolean isUpdated = iAccountService.updateAccountDetail(customerDto);
        if(isUpdated) {
            return ResponseEntity.status(HttpStatus.OK)
            .body(new ResponseDto("200","Updated account successfully"));
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
            .body(new ResponseDto("500","Error in creating account contact dev"));
        }
    }
   
}
