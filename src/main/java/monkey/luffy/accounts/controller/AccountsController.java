package monkey.luffy.accounts.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class AccountsController {

    @GetMapping({"/hello"})
    public String helloworld() {
        return "Hello World";
    }
    
    
}
