package com.whiteshadow.studentlife.schedule;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import com.whiteshadow.studentlife.App;
import com.whiteshadow.studentlife.R;
import com.whiteshadow.studentlife.domain.DaoSession;
import com.whiteshadow.studentlife.domain.Schedule;
import com.whiteshadow.studentlife.domain.ScheduleDao;

import org.greenrobot.greendao.query.QueryBuilder;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * Created by Incau Ionut on 30-Apr-17.
 * Contact: ionut.incau@gmail.com
 */

public class ScheduleFragment extends Fragment {
    private ListView scheduleListView;
    private ArrayList<Button> buttons;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_schedule, container, false);
        scheduleListView = (ListView) view.findViewById(R.id.listview_schedule);
        setButtons(view);
        return view;
    }

    private void setButtons(View view) {
        buttons = new ArrayList();
        final Button moButton = (Button) view.findViewById(R.id.moButton);
        buttons.add(moButton);
        final Button tuButton = (Button) view.findViewById(R.id.tuButton);
        buttons.add(tuButton);
        final Button weButton = (Button) view.findViewById(R.id.weButton);
        buttons.add(weButton);
        final Button thButton = (Button) view.findViewById(R.id.thButton);
        buttons.add(thButton);
        final Button frButton = (Button) view.findViewById(R.id.frButton);
        buttons.add(frButton);

        Calendar calendar = GregorianCalendar.getInstance();
        int day = calendar.get(Calendar.DAY_OF_WEEK);
        if (day == 7 || day == 1) {// for weekend show schedule for monday
            setActive(moButton);
        }
        else {
            setActive(buttons.get(day - 2));
        }
        for (Button b : buttons) {
            b.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick (View v) {
                    setActive((Button) v);
                }
            });
        }
    }

    private void setActive(Button button) {
        for (Button b : buttons) {
            b.setTag(0);
            b.setBackgroundColor(ContextCompat.getColor(getActivity(), R.color.colorWhite));
            b.setTextColor(ContextCompat.getColor(getActivity(), R.color.primary_dark));
        }
        button.setTag(1);
        button.setBackgroundColor(ContextCompat.getColor(getActivity(), R.color.accent));
        button.setTextColor(ContextCompat.getColor(getActivity(), R.color.colorWhite));

        loadSchedule(buttons.indexOf(button) + 1);
    }

    private void loadSchedule(int day) {
        List<Schedule> list = ScheduleProvider.getInstance().getDaySchedule(getActivity(), day);
        ScheduleAdapter scheduleAdapter = new ScheduleAdapter(getActivity(), R.layout.schedule_item, list);
        scheduleListView.setAdapter(scheduleAdapter);
    }
}
