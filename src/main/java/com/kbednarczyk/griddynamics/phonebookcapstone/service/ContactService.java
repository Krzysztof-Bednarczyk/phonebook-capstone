package com.kbednarczyk.griddynamics.phonebookcapstone.service;

import com.kbednarczyk.griddynamics.phonebookcapstone.entity.Contact;
import com.kbednarczyk.griddynamics.phonebookcapstone.entity.PhoneNumber;

import java.util.SortedSet;

public interface ContactService {

    SortedSet<Contact> findAll();

    SortedSet<PhoneNumber> findAllPhoneNumbers(String contactName);
}
