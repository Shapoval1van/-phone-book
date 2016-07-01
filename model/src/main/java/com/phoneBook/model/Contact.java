package com.phoneBook.model;

import javax.persistence.*;

@Entity
@Table(name="phoneBook.contact")
public class Contact {
    @Id
    @Column(name = "id")
    @GeneratedValue
    private Integer id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "address", nullable = true)
    private Address address;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "creator_id", nullable = false)
    private User creator;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "mobil_phone")
    private String mobilPhone;

    @Column(name = "home_phone")
    private String homePhone;

    @Column(name = "email")
    private String email;

    public Contact() {
    }

    @Override
    public String toString() {
        return "Contact{" +
                "id=" + id +
                "| address=" + address +
                "| creator=" + creator +
                "| firstName='" + firstName + '\'' +
                "| lastName='" + lastName + '\'' +
                "| mobilPhone='" + mobilPhone + '\'' +
                "| homePhone='" + homePhone + '\'' +
                "| email='" + email + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public User getCreator_id() {
        return creator;
    }

    public void setCreator_id(User creator) {
        this.creator = creator;
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

    public String getMobilPhone() {
        return mobilPhone;
    }

    public void setMobilPhone(String mobilPhone) {
        this.mobilPhone = mobilPhone;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
