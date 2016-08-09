package com.phonebook.model;



import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "address")
@org.hibernate.annotations.Entity(dynamicInsert = true)
public class Address implements Serializable{
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "address_id_seq")
    @SequenceGenerator(name = "address_id_seq",sequenceName = "address_id_seq",allocationSize=1 )
    private Integer id;

    @Column(name = "country_name", length = 30)
    private String countryName;

    @Column(name = "city_name", length = 30)
    private String cityName;

    @Column(name = "streets_name", length = 40)
    private String streetsName;

    public Address() {
    }

    public Address(int i, String countryName) {
        this.id = i;
        this.countryName = countryName;
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
                '}';
    }

    public Address(int id,String countryName, String cityName, String streetsName) {
        this.id  = id;
        this.countryName = countryName;
        this.cityName = cityName;
        this.streetsName = streetsName;
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
