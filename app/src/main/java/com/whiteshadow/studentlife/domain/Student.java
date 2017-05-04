package com.whiteshadow.studentlife.domain;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by Incau Ionut on 04-May-17.
 * Contact: ionut.incau@gmail.com
 */

@Entity
public class Student {
    @Id(autoincrement = true)
    private Long id;
    private String facebookId;
    private String lastName;
    private String firstName;
    private String username;
    private String email;
    private String phone;
    private String faculty;
    private String university;

    @Generated(hash = 748502615)
    public Student(Long id, String facebookId, String lastName, String firstName,
            String username, String email, String phone, String faculty,
            String university) {
        this.id = id;
        this.facebookId = facebookId;
        this.lastName = lastName;
        this.firstName = firstName;
        this.username = username;
        this.email = email;
        this.phone = phone;
        this.faculty = faculty;
        this.university = university;
    }

    @Generated(hash = 1556870573)
    public Student() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFacebookId() {
        return facebookId;
    }

    public void setFacebookId(String facebookId) {
        this.facebookId = facebookId;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }
}
