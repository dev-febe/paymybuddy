package com.paymybuddy.paymybuddy.Controller;

import com.paymybuddy.paymybuddy.Dao.ContactDao;
import com.paymybuddy.paymybuddy.Dao.TransferDao;
import com.paymybuddy.paymybuddy.Model.Contact;
import com.paymybuddy.paymybuddy.Model.Transfer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class TransactionController {
    ContactDao contactDao;
    TransferDao transferDao;

    @Autowired
    TransactionController(ContactDao contactDao, TransferDao transferDao) {
        this.contactDao = contactDao;
        this.transferDao = transferDao;
    }

    @GetMapping("/transfer")
    public String getTransactions(Model model) {
        List<Contact> connections = this.contactDao.findByUserId(1L);

        List<Transfer> transactions = this.transferDao.findTransferByUserId(1L);

        model.addAttribute("transfer", new Transfer());
        model.addAttribute("connections", connections);
        model.addAttribute("transactions", transactions);

        return "transaction";
    }

    @PostMapping("/transfer")
    public String submitForm(@ModelAttribute Transfer transfer) {

        return "transaction";
    }
}
