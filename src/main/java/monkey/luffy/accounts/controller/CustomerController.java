package monkey.luffy.accounts.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import monkey.luffy.accounts.entity.Customer;
import monkey.luffy.accounts.repository.CutomerRepository;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class CustomerController {

    @Autowired
    private CutomerRepository cutomerRepository;

    @GetMapping("/save")
    public String saveCustomer() {
         
        return "";
    }
    
    
}
