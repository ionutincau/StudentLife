package com.whiteshadow.studentlife;

import android.app.Activity;
import android.content.Context;
import android.support.test.InstrumentationRegistry;

import com.whiteshadow.studentlife.domain.DaoSession;
import com.whiteshadow.studentlife.domain.Schedule;
import com.whiteshadow.studentlife.domain.ScheduleDao;
import com.whiteshadow.studentlife.schedule.ScheduleProvider;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * Created by Incau Ionut on 21-Jun-17.
 * Contact: ionut.incau@gmail.com
 */

public class TestScheduleProvider {
    @Before
    public void setUp() throws Exception {
        deleteAllRecords();
    }

    @Test
    public void testGetDaySchedule() {
        Activity activity = (Activity) InstrumentationRegistry.getContext();
        ScheduleProvider scheduleProvider = ScheduleProvider.getInstance();
        DaoSession daoSession = ((App) activity.getApplication()).getDaoSession();
        ScheduleDao scheduleDao = daoSession.getScheduleDao();
        scheduleProvider.addSchedule(scheduleDao, 1, "8:00", "10:00", "C510", "Seminar", "Ingineria sistemelor soft", "Drd. TIRBAN Paul");
        List<Schedule> scheduleList = scheduleProvider.getDaySchedule(activity, 1);
        assert(scheduleList.size() == 1);
        assert(scheduleList.get(0).getDay() == 1);
        assert(scheduleList.get(0).getHourStart().equals("8:00"));
        assert(scheduleList.get(0).getHourEnd().equals("8:00"));
    }

    private void deleteAllRecords() {

    }
}
