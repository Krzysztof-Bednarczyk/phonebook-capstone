package com.kbednarczyk.griddynamics.phonebookcapstone.entity;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Entity
@Table(name = "contact")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "contact_detail_id")
    @JsonManagedReference
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("contactDetail")
    private ContactDetail contactDetail;

    @OneToMany(mappedBy = "contact",
            cascade = {CascadeType.PERSIST, CascadeType.MERGE,
                    CascadeType.DETACH, CascadeType.REFRESH})
    @JsonManagedReference
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<PhoneNumber> phoneNumbers;

    public Contact() {
    }

    public Contact(Integer id, String firstName, String lastName, String email, ContactDetail contactDetail, List<PhoneNumber> phoneNumbers) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.contactDetail = contactDetail;
        this.phoneNumbers = phoneNumbers;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ContactDetail getContactDetail() {
        return contactDetail;
    }

    public void setContactDetail(ContactDetail contactDetail) {
        this.contactDetail = contactDetail;
    }

    public List<PhoneNumber> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(List<PhoneNumber> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    public void add(PhoneNumber phoneNumber) {
        phoneNumbers = Optional.ofNullable(phoneNumbers).orElseGet(ArrayList::new);
        phoneNumbers.add(phoneNumber);
        phoneNumber.setContact(this);
    }

    @Override
    public String toString() {
        return "Contact{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", contactDetail=" + contactDetail +
                ", phoneNumbers=" + phoneNumbers +
                '}';
    }
}
