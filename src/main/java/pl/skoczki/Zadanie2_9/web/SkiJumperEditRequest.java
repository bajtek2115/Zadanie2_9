package pl.skoczki.Zadanie2_9.web;

import pl.skoczki.Zadanie2_9.service.entity.Country;

public class SkiJumperEditRequest {

    private Long id;
    private String name;
    private String surname;
    private Country country;
    private int age;
    private double jumpRecord;

    public SkiJumperEditRequest(Long id, String name, String surname, Country country, int age, double jumpRecord) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.country = country;
        this.age = age;
        this.jumpRecord = jumpRecord;
    }

    public SkiJumperEditRequest() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getJumpRecord() {
        return jumpRecord;
    }

    public void setJumpRecord(double jumpRecord) {
        this.jumpRecord = jumpRecord;
    }

    @Override
    public String toString() {
        return "SkiJumperEditRequest{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", country='" + country + '\'' +
                ", age=" + age +
                ", jumpRecord=" + jumpRecord +
                '}';
    }
}