package com.paymybuddy.paymybuddy.Controller;

import com.paymybuddy.paymybuddy.Dto.TransactionDto;
import com.paymybuddy.paymybuddy.Model.Contact;
import com.paymybuddy.paymybuddy.Model.Transaction;
import com.paymybuddy.paymybuddy.Model.User;
import com.paymybuddy.paymybuddy.Service.ContactService;
import com.paymybuddy.paymybuddy.Service.TransactionService;
import com.paymybuddy.paymybuddy.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

import java.util.List;

@Controller
public class TransactionController {
    ContactService contactService;
    TransactionService transactionService;
    UserService userService;

    @Autowired
    TransactionController(ContactService contactService, TransactionService transactionService, UserService userService) {
        this.contactService = contactService;
        this.transactionService = transactionService;
        this.userService = userService;
    }

    @GetMapping("/transactions")
    public String getTransactions(Model model) {
        User connectedUser = this.userService.getConnectedUser();

        List<Contact> connections = this
                .contactService
                .getContactsByUser(connectedUser.getId());

        List<Transaction> transactions = this
                .transactionService
                .getTransactionsByUser(connectedUser.getId());

        model.addAttribute("transaction", new TransactionDto());
        model.addAttribute("connections", connections);
        model.addAttribute("transactions", transactions);

        return "transaction";
    }

    @PostMapping("/transactions")
    public String submitForm(@ModelAttribute("transaction") @Valid TransactionDto transaction, BindingResult bindingResult, Model model) {
        User connectedUser = this.userService.getConnectedUser();

        List<Contact> connections = this
                .contactService
                .getContactsByUser(connectedUser.getId());

        transaction.setUserId(connectedUser.getId());
        transaction.setType(Transaction.TYPE_TRANSFER);
        transaction.setStatus(Transaction.STATUS_IS_OK);

        // validate the form and proceed to processing
        if(!bindingResult.hasErrors()){
            try {
                this.transactionService.saveTransaction(transaction);
                model.addAttribute("confirm", true);
            } catch (Exception e) {
                model.addAttribute("confirm", false);
                model.addAttribute("isBalanceInsufficient", true);
            }
            model.addAttribute("transaction", new TransactionDto());
        }

        List<Transaction> transactions = this
                .transactionService
                .getTransactionsByUser(connectedUser.getId());

       // model.addAttribute("transaction", new TransactionDto());
        model.addAttribute("connections", connections);
        model.addAttribute("transactions", transactions);
        return "transaction";
    }
}
