package com.paymybuddy.paymybuddy.Service;

import com.paymybuddy.paymybuddy.Dao.ContactDao;
import com.paymybuddy.paymybuddy.Model.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactService {
    private final ContactDao contactDao;

    @Autowired
    ContactService(ContactDao contactDao) {
        this.contactDao = contactDao;
    }

    public List<Contact> getContactsByUser(Long userId) {
        return this.contactDao.findByUserId(userId);
    }
}
