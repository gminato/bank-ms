package monkey.luffy.accounts.controller;


import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
@RequestMapping(path = "api/customer",produces = {MediaType.APPLICATION_JSON_VALUE})
public class CustomerController {

}
