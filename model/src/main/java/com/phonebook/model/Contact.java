package com.phonebook.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="contact")
public class Contact implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "contact_id_seq")
    @SequenceGenerator(name = "contact_id_seq",sequenceName = "contact_id_seq",allocationSize=1 )
    private Integer id;

    @OneToOne(fetch=FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "address", nullable = true, referencedColumnName = "id")
    private Address address;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "creator_id", referencedColumnName = "id")
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

    @JsonIgnore
    @Column(name = "date_creating")
    private Date dateCreating;

    @ManyToOne
    @JoinColumn(name = "group_id", referencedColumnName = "id")
    private Group group;

    public Contact() {
    }

    @Override
    public String toString() {
        return "Contact{" +
                "id=" + id +
                "| address=" + address.getStreetsName() +
                "| creator=" + creator.getUserName() +
                "| firstName='" + firstName + '\'' +
                "| lastName='" + lastName + '\'' +
                "| mobilPhone='" + mobilPhone + '\'' +
                "| homePhone='" + homePhone + '\'' +
                "| email='" + email + '\'' +
                '}';
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
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

    public Date getDateCreating() {
        return dateCreating;
    }

    public void setDateCreating(Date dateCreating) {
        this.dateCreating = dateCreating;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }


}
