package com.musyimi.repair;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Repair {

    @Id
    @SequenceGenerator(
            name = "repair_id_sequence",
            sequenceName = "repair_id_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "repair_id_sequence"
    )
    private Integer id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String brand;
    @Column(nullable = false)
    private Integer phoneNumber;
    @Column(nullable = false)
    private String issue;

    public Repair(){}


    public Repair(Integer id, String name, String title, String brand, String issue, Integer phoneNumber) {
        this.id = id;
        this.name = name;
        this.title = title;
        this.brand = brand;
        this.issue = issue;
        this.phoneNumber = phoneNumber;
    }

    public Repair( String name, String title, String brand, String issue, Integer phoneNumber) {
        this.name = name;
        this.title = title;
        this.brand = brand;
        this.issue = issue;
        this.phoneNumber = phoneNumber;
    }

    public Integer getId() {
        return id;
    }

    public Integer getphoneNumber() {
        return phoneNumber;
    }

    public void setphoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getIssue() {
        return issue;
    }

    public void setIssue(String issue) {
        this.issue = issue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Repair repair = (Repair) o;
        return Objects.equals(id, repair.id) && Objects.equals(name, repair.name) && Objects.equals(title, repair.title) && Objects.equals(brand, repair.brand) && Objects.equals(phoneNumber, repair.phoneNumber) && Objects.equals(issue, repair.issue);
    }


    @Override
    public int hashCode() {
        return Objects.hash(id, name, title, brand, phoneNumber, issue);
    }

    @Override
    public String toString() {
        return "Repair{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", title='" + title + '\'' +
                ", brand='" + brand + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", issue='" + issue + '\'' +
                '}';
    }


}