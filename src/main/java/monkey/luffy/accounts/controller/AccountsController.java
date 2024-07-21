package monkey.luffy.accounts.controller;

import org.springframework.web.bind.annotation.RestController;

import monkey.luffy.accounts.dto.CustomerDto;
import monkey.luffy.accounts.dto.ResponseDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.autoconfigure.observation.ObservationProperties.Http;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;



@RestController
@RequestMapping(path = "/api/account",produces = {MediaType.APPLICATION_JSON_VALUE})
public class AccountsController {


    @PostMapping("/create")
    public ResponseEntity<ResponseDto> createAccount(@RequestBody String entity) {

        return ResponseEntity.status(HttpStatus.CREATED)
        .body(new ResponseDto("201","Record created successfully"));
    }
    
    
}
