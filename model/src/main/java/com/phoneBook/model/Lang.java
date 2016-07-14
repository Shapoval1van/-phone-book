package com.phoneBook.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name ="lang")
public class Lang implements Serializable{
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(name = "lang", nullable = false, length = 20)
    private String lang;

    public Lang() {
    }

    public Lang(int id, String lang) {
        this.id = id;
        this.lang = lang;
    }

    @Override
    public String toString() {
        return "Lang{" +
                "id=" + id +
                "| lang='" + lang + '\'' +
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


}
