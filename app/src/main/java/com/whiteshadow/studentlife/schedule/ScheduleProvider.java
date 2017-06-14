package com.whiteshadow.studentlife.schedule;

import android.app.Activity;

import com.whiteshadow.studentlife.App;
import com.whiteshadow.studentlife.domain.DaoSession;
import com.whiteshadow.studentlife.domain.Schedule;
import com.whiteshadow.studentlife.domain.ScheduleDao;

import java.util.List;

/**
 * Created by Incau Ionut on 14-Jun-17.
 * Contact: ionut.incau@gmail.com
 */

public class ScheduleProvider {
    private static ScheduleProvider instance;

    private ScheduleProvider() {

    }

    public static ScheduleProvider getInstance() {
        if (instance == null) {
            instance = new ScheduleProvider();
        }
        return instance;
    }

    public List<Schedule> getDaySchedule(Activity activity, int day) {
        DaoSession daoSession = ((App) activity.getApplication()).getDaoSession();
        ScheduleDao scheduleDao = daoSession.getScheduleDao();
        List<Schedule> list = scheduleDao.queryBuilder().where(ScheduleDao.Properties.Day.eq(day)).list();
        return list;
    }

    public void addDummyData(ScheduleDao scheduleDao) {
        addSchedule(scheduleDao, 1, "8:00", "10:00", "C510", "Seminar", "Ingineria sistemelor soft", "Drd. TIRBAN Paul");
        addSchedule(scheduleDao, 1, "10:00", "12:00", "C512", "Seminar", "Inteligenta artificiala", "Drd. ENESCU Alina");
        addSchedule(scheduleDao, 1, "12:00", "14:00", "L336", "Laborator", "Proiect colectiv", "Asist. COROIU Adriana");
        addSchedule(scheduleDao, 1, "14:00", "16:00", "L339", "Laborator", "Retele de calculatoare", "Lect. DRAGOS Radu");
        addSchedule(scheduleDao, 1, "16:00", "18:00", "L301", "Laborator", "Ingineria sistemelor soft", "Drd. Sima Ioan");
        addSchedule(scheduleDao, 2, "10:00", "12:00", "L002", "Laborator", "Inteligenta artificiala", "Drd. ENESCU Alina");
        addSchedule(scheduleDao, 2, "14:00", "16:00", "6/II", "Curs", "Managementul clasei de elevi", "Conf. VALCAN Dumitru");
        addSchedule(scheduleDao, 2, "16:00", "18:00", "6/II", "Seminar", "Managementul clasei de elevi", "Conf. VALCAN Dumitru");
        addSchedule(scheduleDao, 3, "8:00", "10:00", "2/I", "Curs", "Inteligenta artificiala", "Prof. DIOSAN Laura");
        addSchedule(scheduleDao, 3, "10:00", "12:00", "7/I", "Curs", "Retele de calculatoare", "Lect. DRAGOS Radu");
        addSchedule(scheduleDao, 3, "12:00", "14:00", "L306", "Laborator", "Ingineria sistemelor soft", "Drd. Sima Ioan");
        addSchedule(scheduleDao, 4, "8:00", "10:00", "5/I", "Curs", "Tehnici de optimizare", "Lect. BERINDE Stefan");
        addSchedule(scheduleDao, 4, "12:00", "14:00", "6/II", "Curs", "Istoria matematicii", "Lect. ILEA Veronica");
        addSchedule(scheduleDao, 5, "8:00", "10:00", "6/II", "Curs", "Istoria informaticii", "Lect. STERCA Adrian");
        addSchedule(scheduleDao, 5, "10:00", "12:00", "A311", "Seminar", "Tehnici de optimizare", "Lect. BERINDE Stefan");
        addSchedule(scheduleDao, 5, "14:00", "16:00", "A2", "Curs", "Ingineria sistemelor soft", "Conf. CHIOREAN Dan");
    }

    private void addSchedule(ScheduleDao scheduleDao, int day, String hourStart,  String hourEnd, String room, String type, String className, String teacherName) {
        Schedule schedule = new Schedule();
        schedule.setDay(day);
        schedule.setHourStart(hourStart);
        schedule.setHourEnd(hourEnd);
        schedule.setRoom(room);
        schedule.setTeacherName(teacherName);
        schedule.setClassName(className);
        schedule.setType(type);
        scheduleDao.insert(schedule);
    }
}
