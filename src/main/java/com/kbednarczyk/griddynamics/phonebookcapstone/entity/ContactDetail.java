package com.kbednarczyk.griddynamics.phonebookcapstone.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "contact_detail")
public class ContactDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "occupation")
    private String occupation;

    @Column(name = "hobby")
    private String hobby;

    @Column(name = "group")
    private String group;

    public ContactDetail() {
    }

    public ContactDetail(String occupation, String hobby, String group) {
        this.occupation = occupation;
        this.hobby = hobby;
        this.group = group;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    @Override
    public String toString() {
        return "ContactDetail{" +
                "id=" + id +
                ", occupation='" + occupation + '\'' +
                ", hobby='" + hobby + '\'' +
                ", group='" + group + '\'' +
                '}';
    }
}
