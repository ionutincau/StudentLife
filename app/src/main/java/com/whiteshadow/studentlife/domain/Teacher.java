package com.whiteshadow.studentlife.domain;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by Incau Ionut on 04-May-17.
 * Contact: ionut.incau@gmail.com
 */

@Entity
public class Teacher {
    @Id(autoincrement = true)
    private Long id;
    private String lastName;
    private String firstName;

    @Generated(hash = 632582949)
    public Teacher(Long id, String lastName, String firstName) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
    }

    @Generated(hash = 1630413260)
    public Teacher() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
}
