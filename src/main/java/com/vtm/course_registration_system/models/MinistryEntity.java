package com.vtm.course_registration_system.models;

import java.util.Objects;

public class MinistryEntity {
    private int id;
    private String name;
    private String username;
    private String password;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MinistryEntity(){}

    public MinistryEntity(int id, String username, String password, String name) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.name = name;
    }

    public MinistryEntity(String username, String password, String name) {
        this.username = username;
        this.password = password;
        this.name = name;
    }

    public Object[] toArray() {
        Object[] arr = new Object[4];
        arr[0] = this.id;
        arr[1] = this.name;
        arr[2] = this.username;
        arr[3] = this.password;
        return arr;
    }

    @Override
    public String toString() {
        return "MinistryEntity{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MinistryEntity that = (MinistryEntity) o;
        return id == that.id && Objects.equals(username, that.username) && Objects.equals(password, that.password) && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password, name);
    }
}
