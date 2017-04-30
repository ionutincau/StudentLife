package com.whiteshadow.studentlife.schedule;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.whiteshadow.studentlife.App;
import com.whiteshadow.studentlife.R;

import org.greenrobot.greendao.query.QueryBuilder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Incau Ionut on 30-Apr-17.
 * Contact: ionut.incau@gmail.com
 */

public class ScheduleFragment extends Fragment {
    private ListView scheduleListView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_schedule, container, false);

        //// TODO: 30-Apr-17 remove temp
        DaoSession daoSession = ((App) getActivity().getApplication()).getDaoSession();
        ScheduleDao scheduleDao = daoSession.getScheduleDao();

        Schedule sch2 = new Schedule();
        sch2.setDay(5);
        sch2.setHourStart("10:00");
        sch2.setHourEnd("2:00");
        sch2.setRoom("134");
        sch2.setTeacherName("Johnny2");
        scheduleDao.insert(sch2);

        QueryBuilder<Schedule> qb = scheduleDao.queryBuilder();
        qb.orderAsc(ScheduleDao.Properties.Day).build();
        List<Schedule> list = qb.list();

        scheduleListView = (ListView) view.findViewById(R.id.listview_schedule);
        ScheduleAdapter scheduleAdapter = new ScheduleAdapter(getActivity(), R.layout.schedule_item, list);
        scheduleListView.setAdapter(scheduleAdapter);

        return view;
    }
}
