package com.example.mad;

import java.io.Serializable;

public class Faculty implements Serializable {
    private String name;
    private String designation;

    private String gender;

    private String date_of_join;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDate_of_join() {
        return date_of_join;
    }

    public void setDate_of_join(String date_of_join) {
        this.date_of_join = date_of_join;
    }
}
