package com.whiteshadow.studentlife.domain;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;

/**
 * Created by Incau Ionut on 14-Jun-17.
 * Contact: ionut.incau@gmail.com
 */

@Entity
public class Grade {
    @Id(autoincrement = true)
    private Long id;
    private int semester;
    private String courseName;
    private int number;
    private int credits;

    public Grade() {

    }

    @Generated(hash = 1210254482)
    public Grade(Long id, int semester, String courseName, int number,
            int credits) {
        this.id = id;
        this.semester = semester;
        this.courseName = courseName;
        this.number = number;
        this.credits = credits;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
