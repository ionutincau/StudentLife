package com.whiteshadow.studentlife.schedule;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.whiteshadow.studentlife.R;
import com.whiteshadow.studentlife.domain.Schedule;

import java.util.List;

/**
 * Created by Incau Ionut on 30-Apr-17.
 * Contact: ionut.incau@gmail.com
 */

public class ScheduleAdapter extends ArrayAdapter {

    public static class ViewHolder {
        public final TextView hour;
        public final TextView room;
        public final TextView className;
        public final TextView teacherName;
        public final TextView type;

        public ViewHolder(View view) {
            hour = (TextView) view.findViewById(R.id.hour);
            room = (TextView) view.findViewById(R.id.room);
            className = (TextView) view.findViewById(R.id.className);
            teacherName = (TextView) view.findViewById(R.id.teacherName);
            type = (TextView) view.findViewById(R.id.type);
        }
    }

    public ScheduleAdapter(Context context, int resource, List<Schedule> scheduleList) {
        super(context, resource, scheduleList);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Schedule schedule = (Schedule) getItem(position);
        View view = convertView;
        ViewHolder holder;

        if (view == null) {
            view = LayoutInflater.from(getContext()).inflate(R.layout.schedule_item, parent, false);
            holder = new ViewHolder(view);
            view.setTag(holder);
        }
        else {
            holder = (ViewHolder) view.getTag();
        }

        holder.hour.setText(schedule.getHourStart() + " - " + schedule.getHourEnd());
        holder.room.setText(schedule.getRoom());
        holder.className.setText(schedule.getClassName());
        holder.teacherName.setText(schedule.getTeacherName());
        holder.type.setText(schedule.getType());

        return view;
    }
}
