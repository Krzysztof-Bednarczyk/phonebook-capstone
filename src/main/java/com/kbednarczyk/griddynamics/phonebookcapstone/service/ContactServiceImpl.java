package com.kbednarczyk.griddynamics.phonebookcapstone.service;

import com.kbednarczyk.griddynamics.phonebookcapstone.entity.Contact;
import com.kbednarczyk.griddynamics.phonebookcapstone.entity.PhoneNumber;
import com.kbednarczyk.griddynamics.phonebookcapstone.exceptionhandling.model.ContactNotFoundException;
import com.kbednarczyk.griddynamics.phonebookcapstone.repository.ContactRepository;
import com.kbednarczyk.griddynamics.phonebookcapstone.repository.PhoneNumberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactServiceImpl implements ContactService {

    private final ContactRepository contactRepository;
    private final PhoneNumberRepository phoneNumberRepository;

    @Autowired
    public ContactServiceImpl(ContactRepository contactRepository, PhoneNumberRepository phoneNumberRepository) {
        this.contactRepository = contactRepository;
        this.phoneNumberRepository = phoneNumberRepository;
    }

    @Override
    public List<Contact> findAll() {
        return contactRepository.findAllWithChildren();
    }

    @Override
    public Contact findByName(String contactName) {
        return contactRepository.findAllWithChildren()
                .stream()
                .filter(contact -> contact.getLastName().equals(contactName))
                .findFirst()
                .orElseThrow(() -> new ContactNotFoundException(HttpStatus.NOT_FOUND, String.format("Contact: %s is not available.", contactName)));
    }

    @Override
    public List<PhoneNumber> findAllPhoneNumbers(String contactName) {
        return findByName(contactName)
                .getPhoneNumbers();
    }
    @Override
    public void updatePhoneNumbers(String contactName, PhoneNumber phoneNumber) {
        Contact contactToUpdate = findByName(contactName);
        contactToUpdate.add(phoneNumber);
        contactRepository.save(contactToUpdate);
    }

    @Override
    public void addContact(Contact contact) {
        contactRepository.save(contact);
    }

    @Override
    public void deleteContact(String contactName) {
        Contact contact = findByName(contactName);
        List<PhoneNumber> phones = contact.getPhoneNumbers();
        System.out.println(phones);
        phones.forEach(phoneNumber -> phoneNumberRepository.deleteById(phoneNumber.getId()));
        contactRepository.deleteByContactName(contactName);
    }
}
