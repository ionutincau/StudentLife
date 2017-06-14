package com.whiteshadow.studentlife.grades;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.whiteshadow.studentlife.R;
import com.whiteshadow.studentlife.domain.Grade;

import java.text.DecimalFormat;
import java.util.List;

/**
 * Created by Incau Ionut on 14-Jun-17.
 * Contact: ionut.incau@gmail.com
 */

public class GradeAdapter extends ArrayAdapter {
    private List<Grade> gradeList;

    public static class ViewHolder {
        public final TextView gradeNumber;
        public final TextView credits;
        public final TextView course;

        public ViewHolder(View view) {
            gradeNumber = (TextView) view.findViewById(R.id.gradeNumber);
            credits = (TextView) view.findViewById(R.id.credits);
            course = (TextView) view.findViewById(R.id.course);
        }
    }

    public GradeAdapter(Context context, int resource, List<Grade> gradeList) {
        super(context, resource, gradeList);
        this.gradeList = gradeList;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        GradeAdapter.ViewHolder holder;

        if (view == null) {
            view = LayoutInflater.from(getContext()).inflate(R.layout.grade_item, parent, false);
            holder = new GradeAdapter.ViewHolder(view);
            view.setTag(holder);
        }
        else {
            holder = (GradeAdapter.ViewHolder) view.getTag();
        }

        if (position == 0) {
            DecimalFormat df = new DecimalFormat("#.00");
            holder.gradeNumber.setText(df.format(getAverage()));
            holder.gradeNumber.setTextSize(14);
            holder.credits.setText(String.valueOf(getTotalCredits()));
            holder.course.setText(getMessage());
        }
        else {
            Grade grade = (Grade) getItem(position);
            holder.gradeNumber.setText(String.valueOf(grade.getNumber()));
            holder.gradeNumber.setTextSize(20);
            if (grade.getNumber() >= 5) holder.gradeNumber.setTextColor(ContextCompat.getColor(view.getContext(), R.color.colorGood));
            else holder.gradeNumber.setTextColor(ContextCompat.getColor(view.getContext(), R.color.colorBad));
            holder.credits.setText(String.valueOf(grade.getCredits()));
            holder.course.setText(grade.getCourseName());
        }

        return view;
    }

    private int getTotalCredits() {
        int total = 0;
        for (Grade grade : this.gradeList) {
            total += grade.getCredits();
        }
        return total;
    }

    private double getAverage() {
        double total = 0;
        for (Grade grade : this.gradeList) {
            int value = grade.getNumber() * grade.getCredits();
            total += value;
        }
        return total / getTotalCredits();
    }

    private String getMessage() {
        if (getAverage() > 9) return "Congratulation!";
        if (getAverage() > 7) return "Very good!";
        return "Nice!";
    }
}
