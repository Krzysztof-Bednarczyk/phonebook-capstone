package com.kbednarczyk.griddynamics.phonebookcapstone.rest;


import com.kbednarczyk.griddynamics.phonebookcapstone.entity.Contact;
import com.kbednarczyk.griddynamics.phonebookcapstone.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.SortedSet;

@RestController
@RequestMapping("/api/v1/contacts")
public class PhoneBookController {

    private ContactService contactService;

    @Autowired
    public PhoneBookController(ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping
    public SortedSet<Contact> getAll() {
        return contactService.findAll();
    }
}
