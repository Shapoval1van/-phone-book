package com.phoneBook.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

public class Lang {
    @Id
    @Column(name = "id")
    @GeneratedValue
    private Integer id;

    @Column(name = "lang", nullable = false)
    private String lang;

    @OneToOne(mappedBy = "lang")
    private User user;

    public Lang() {
    }

    @Override
    public String toString() {
        return "Lang{" +
                "id=" + id +
                "| lang='" + lang + '\'' +
                "| user=" + user +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
