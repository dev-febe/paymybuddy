package com.paymybuddy.paymybuddy.Controller;

import com.paymybuddy.paymybuddy.Dto.TransactionDto;
import com.paymybuddy.paymybuddy.Model.Contact;
import com.paymybuddy.paymybuddy.Model.Transaction;
import com.paymybuddy.paymybuddy.Service.ContactService;
import com.paymybuddy.paymybuddy.Service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class TransactionController {
    ContactService contactService;
    TransactionService transactionService;

    @Autowired
    TransactionController(ContactService contactService, TransactionService transactionService) {
        this.contactService = contactService;
        this.transactionService = transactionService;
    }

    @GetMapping("/transactions")
    public String getTransactions(Model model) {
        List<Contact> connections = this.contactService.getContactsByUser(1L);

        List<Transaction> transactions = this.transactionService.getTransactionsByUser(1L);

        model.addAttribute("transaction", new TransactionDto());
        model.addAttribute("connections", connections);
        model.addAttribute("transactions", transactions);

        return "transaction";
    }

    @PostMapping("/transactions")
    public String submitForm(@ModelAttribute TransactionDto transaction, Model model) {
        List<Contact> connections = this.contactService.getContactsByUser(1L);
        transaction.setUserId(1L);
        transaction.setType("TRANSACTION");
        transaction.setStatus("DONE");

        this.transactionService.saveTransaction(transaction);

        List<Transaction> transactions = this.transactionService.getTransactionsByUser(1L);
        model.addAttribute("transaction", new TransactionDto());
        model.addAttribute("connections", connections);
        model.addAttribute("transactions", transactions);
        return "transaction";
    }
}
