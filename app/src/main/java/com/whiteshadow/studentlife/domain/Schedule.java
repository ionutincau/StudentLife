package com.whiteshadow.studentlife.domain;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by Incau Ionut on 30-Apr-17.
 * Contact: ionut.incau@gmail.com
 */

@Entity
public class Schedule {
    @Id(autoincrement = true)
    private Long id;
    @NotNull
    private int day;
    private String hourStart;
    private String hourEnd;
    private String room;
    private String className;
    private String teacherName;
    private String type;

    @Generated(hash = 562618825)
    public Schedule(Long id, int day, String hourStart, String hourEnd, String room, String className, String teacherName, String type) {
        this.id = id;
        this.day = day;
        this.hourStart = hourStart;
        this.hourEnd = hourEnd;
        this.room = room;
        this.className = className;
        this.teacherName = teacherName;
        this.type = type;
    }

    @Generated(hash = 729319394)
    public Schedule() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public String getHourStart() {
        return hourStart;
    }

    public void setHourStart(String hourStart) {
        this.hourStart = hourStart;
    }

    public String getHourEnd() {
        return hourEnd;
    }

    public void setHourEnd(String hourEnd) {
        this.hourEnd = hourEnd;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
