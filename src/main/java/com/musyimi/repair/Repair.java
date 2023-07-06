package com.musyimi.repair;

import java.util.Objects;

public class Repair {
    private Integer id;
    private String name;
    private String title;
    private String brand;
    private Integer phone_number;
    private String issue;

    public Repair(){}

    public Repair(Integer phone_number) {
        this.phone_number = phone_number;
    }

    public Repair(Integer id, String name, String title, String brand, String issue, Integer phone_number) {
        this.id = id;
        this.name = name;
        this.title = title;
        this.brand = brand;
        this.issue = issue;
        this.phone_number = phone_number;
    }

    public Integer getId() {
        return id;
    }

    public Integer getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(Integer phone_number) {
        this.phone_number = phone_number;
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
        return Objects.equals(id, repair.id) && Objects.equals(name, repair.name) && Objects.equals(title, repair.title) && Objects.equals(brand, repair.brand) && Objects.equals(phone_number, repair.phone_number) && Objects.equals(issue, repair.issue);
    }


    @Override
    public int hashCode() {
        return Objects.hash(id, name, title, brand, phone_number, issue);
    }

    @Override
    public String toString() {
        return "Repair{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", title='" + title + '\'' +
                ", brand='" + brand + '\'' +
                ", phone_number=" + phone_number +
                ", issue='" + issue + '\'' +
                '}';
    }


}