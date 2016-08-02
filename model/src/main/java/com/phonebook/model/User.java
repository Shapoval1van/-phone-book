package com.phonebook.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "person")
@org.hibernate.annotations.Entity(dynamicInsert = true)
public class User implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "person_id_seq")
    @SequenceGenerator(name = "person_id_seq",sequenceName = "person_id_seq",allocationSize=1 )
    private Integer id;

    @OneToOne
    @JoinColumn(name = "lang_id", referencedColumnName = "id")
    private Lang lang;

    @Column(name = "deleted")
    private Boolean deleted;

    @Column(name = "user_name", nullable = false)
    private String userName;

    @Column(name = "user_password", nullable = false)
    private String password;

    @OneToMany(mappedBy = "creator")
    private Set<Contact> contact;

    @OneToMany(mappedBy = "creator")
    private Set<Group> group;

    @Transient
    private String passwordConfirm;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                "| lang=" + lang +
                "| deleted=" + deleted +
                "| userName='" + userName + '\'' +
                "| password='" + password + '\'' +
                "| contact=" + contact +
                "| confPas="+ passwordConfirm +
                '}';
    }

    public User() {
    }

    public User(int id) {
        this.id =  id;
    }

    public User(String userName){
        this.userName = userName;
    }

    public Set<Group> getGroup() {
        return group;
    }

    public void setGroup(Set<Group> group) {
        this.group = group;
    }

    public Integer getId() {
        return id;
    }

    public Set<Contact> getContact() {
        return contact;
    }

    public void setContact(Set<Contact> contact) {
        this.contact = contact;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Lang getLang() {
        return lang;
    }

    public void setLang(Lang lang) {
        this.lang = lang;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }
}
