package com.paymybuddy.paymybuddy.Service;

import com.paymybuddy.paymybuddy.Dao.ContactDao;
import com.paymybuddy.paymybuddy.Model.Contact;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class ContactServiceTest {
    @Mock
    ContactDao contactDao;

    @InjectMocks
    ContactService contactService;

    @BeforeEach
    public void setupTest() {
        List<Contact> contacts = new ArrayList<>();
        contacts.add(new Contact());
        contacts.add(new Contact(1L, "Ben"));
        when(contactDao.findByUserId(1L)).thenReturn(contacts);
    }

    @Test
    public void getContactsByUser_ShouldReturnAList_Test() {
        List<Contact> contacts = contactService.getContactsByUser(1L);
        assertEquals(contacts.size(), 2);
        verify(contactDao, times(1)).findByUserId(1L);
    }

}
