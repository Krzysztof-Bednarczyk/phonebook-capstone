package com.kbednarczyk.griddynamics.phonebookcapstone.service;

import com.kbednarczyk.griddynamics.phonebookcapstone.entity.Contact;
import com.kbednarczyk.griddynamics.phonebookcapstone.entity.PhoneNumber;

import java.util.List;

public interface ContactService {

    List<Contact> findAll();

    Contact findByName(String contactName);

    List<PhoneNumber> findAllPhoneNumbers(String contactName);

    void updatePhoneNumbers(String contactName, PhoneNumber phoneNumber);

    void addContact(Contact contact);

    void deleteContact(String contactName);
}
