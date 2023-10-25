package com.kbednarczyk.griddynamics.phonebookcapstone.rest;


import com.kbednarczyk.griddynamics.phonebookcapstone.entity.Contact;
import com.kbednarczyk.griddynamics.phonebookcapstone.entity.PhoneNumber;
import com.kbednarczyk.griddynamics.phonebookcapstone.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/contacts")
public class PhoneBookController {

    private final ContactService contactService;

    @Autowired
    public PhoneBookController(ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping
    public List<Contact> getAll() {
        return contactService.findAll();
    }

    @GetMapping("/{contactName}")
    public List<PhoneNumber> getAllByName(@PathVariable String contactName){
        return contactService.findAllPhoneNumbers(contactName);
    }
    @PutMapping("/{contactName}")
    @ResponseStatus(HttpStatus.CREATED)
    public void updateContactsPhoneNumbers(@PathVariable String contactName, @RequestBody List<PhoneNumber> phoneNumbers){
        phoneNumbers.forEach(phoneNumber -> contactService.updatePhoneNumbers(contactName, phoneNumber));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addContact(@RequestBody Contact contact){
        contactService.addContact(contact);
    }
}
