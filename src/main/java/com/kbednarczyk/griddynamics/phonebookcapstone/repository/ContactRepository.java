package com.kbednarczyk.griddynamics.phonebookcapstone.repository;

import com.kbednarczyk.griddynamics.phonebookcapstone.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Integer> {

    @Query("SELECT DISTINCT c FROM Contact c LEFT JOIN FETCH c.phoneNumbers p")
    List<Contact> findAllWithChildren();

    @Modifying
    @Transactional
    @Query("DELETE  FROM Contact c WHERE c.lastName = ?1")
    void deleteByContactName(String contactName);
}
