package pl.skoczki.Zadanie2_9.service.entity;

import jakarta.persistence.*;

@Entity
@Table
public class SkiJumper {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String surname;
    private String country;
    private int age;
    private double jumpRecord;

    public SkiJumper(String name, String surname, String country, int age, double jumpRecord) {
        this.name = name;
        this.surname = surname;
        this.country = country;
        this.age = age;
        this.jumpRecord = jumpRecord;
    }

    public SkiJumper() {
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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
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
        return "SkiJumper{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", country='" + country + '\'' +
                ", age=" + age +
                ", jumpRecord=" + jumpRecord +
                '}';
    }
}