package com.phoneBook.model;


import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.OneToOne;

public class Address {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "country_name")
    private String countryName;

    @Column(name = "city_name")
    private String cityName;

    @Column(name = "streets_name")
    private String streetsName;

    @OneToOne(mappedBy = "address")
    private Contact contact;

    public Address() {
    }

    public Address(Integer id, String countryName, String cityName, String streetsName) {
        this.id = id;
        this.countryName = countryName;
        this.cityName = cityName;
        this.streetsName = streetsName;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                "| countryName='" + countryName + '\'' +
                "| cityName='" + cityName + '\'' +
                "| streetsName='" + streetsName + '\'' +
                "| contact=" + contact +
                '}';
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getStreetsName() {
        return streetsName;
    }

    public void setStreetsName(String streetsName) {
        this.streetsName = streetsName;
    }
}
