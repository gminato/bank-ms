package monkey.luffy.accounts.controller;

import org.springframework.web.bind.annotation.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class AccountsController {

    @Autowired

    @GetMapping({"/hello"})
    public String helloworld() {
        return "hello world";
    }

    
}
