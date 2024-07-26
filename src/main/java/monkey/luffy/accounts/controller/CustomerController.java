package monkey.luffy.accounts.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.AllArgsConstructor;
import monkey.luffy.accounts.dto.CustomerDto;
import monkey.luffy.accounts.dto.ResponseDto;
import monkey.luffy.accounts.service.IAccountService;


@Controller
@AllArgsConstructor
@RequestMapping(path = "api/customer",produces = {MediaType.APPLICATION_JSON_VALUE})
public class CustomerController {

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
    
    
}
