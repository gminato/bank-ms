package monkey.luffy.accounts.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class CustomerController {


    @GetMapping("/save")
    public String saveCustomer() {
        return "";
    }
    
    
}
