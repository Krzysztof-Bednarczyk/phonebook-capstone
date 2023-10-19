package com.kbednarczyk.griddynamics.phonebookcapstone.repository;

import com.kbednarczyk.griddynamics.phonebookcapstone.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.SortedSet;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Integer> {

    @Query("SELECT DISTINCT c FROM Contact c LEFT JOIN FETCH c.phoneNumbers p")
    SortedSet<Contact> findAllWithChildren();
}
