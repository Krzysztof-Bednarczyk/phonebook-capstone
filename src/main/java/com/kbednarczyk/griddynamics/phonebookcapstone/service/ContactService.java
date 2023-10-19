package com.kbednarczyk.griddynamics.phonebookcapstone.service;

import com.kbednarczyk.griddynamics.phonebookcapstone.entity.Contact;

import java.util.SortedSet;

public interface ContactService {

    SortedSet<Contact> findAll();
}
