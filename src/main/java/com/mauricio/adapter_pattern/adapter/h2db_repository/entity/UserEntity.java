package com.mauricio.adapter_pattern.adapter.h2db_repository.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "User")
public class UserEntity {

    @Id
    private Integer id;
    private String firstName;
    private String lastName;
    private int age;
    private Integer idCategory;

    public UserEntity() {}

    public UserEntity(Integer id, String firstName, String lastName, int age, Integer idCategory) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.idCategory = idCategory;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Integer getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(Integer idCategory) {
        this.idCategory = idCategory;
    }
}
