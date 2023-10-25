package com.kbednarczyk.griddynamics.phonebookcapstone.repository;

import com.kbednarczyk.griddynamics.phonebookcapstone.entity.PhoneNumber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhoneNumberRepository extends JpaRepository<PhoneNumber, Integer> {

    void deleteById(Integer id);
}
