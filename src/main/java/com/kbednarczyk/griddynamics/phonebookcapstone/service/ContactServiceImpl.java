package com.kbednarczyk.griddynamics.phonebookcapstone.service;

import com.kbednarczyk.griddynamics.phonebookcapstone.entity.Contact;
import com.kbednarczyk.griddynamics.phonebookcapstone.entity.PhoneNumber;
import com.kbednarczyk.griddynamics.phonebookcapstone.exceptionhandling.model.ContactNotFoundException;
import com.kbednarczyk.griddynamics.phonebookcapstone.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.SortedSet;
import java.util.TreeSet;

@Service
public class ContactServiceImpl implements ContactService {

    private final ContactRepository contactRepository;

    @Autowired
    public ContactServiceImpl(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    @Override
    public SortedSet<Contact> findAll() {
        return new TreeSet<>(contactRepository.findAllWithChildren());
    }

    @Override
    public SortedSet<PhoneNumber> findAllPhoneNumbers(String contactName) {
        return contactRepository.findAllWithChildren()
                .stream()
                .filter(contact -> contact.getLastName().equals(contactName))
                .findFirst()
                .orElseThrow(() -> new ContactNotFoundException(HttpStatus.NOT_FOUND, String.format("Contact: %s is not available.", contactName) ))
                .getPhoneNumbers();
    }
}
