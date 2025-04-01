package com.synergisticit.RESTController;

import com.synergisticit.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class TransactionsController {

    @GetMapping("/transactions")
    public String showPickTransactionButtonsPage(){

        return "transactions";
    }
}
