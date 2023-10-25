package com.kbednarczyk.griddynamics.phonebookcapstone.service;

import com.kbednarczyk.griddynamics.phonebookcapstone.entity.Contact;
import com.kbednarczyk.griddynamics.phonebookcapstone.entity.PhoneNumber;

import java.util.List;

public interface ContactService {

    List<Contact> findAll();

    Contact findByName(String contactName);

    List<PhoneNumber> findAllPhoneNumbers(String contactName);

}
