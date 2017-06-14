package com.whiteshadow.studentlife.grades;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import com.whiteshadow.studentlife.R;
import com.whiteshadow.studentlife.domain.Grade;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Incau Ionut on 14-Jun-17.
 * Contact: ionut.incau@gmail.com
 */

public class GradeFragment extends Fragment {
    private ListView gradeListView;
    private ArrayList<Button> buttons;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_grade, container, false);
        gradeListView = (ListView) view.findViewById(R.id.listview_grade);
        setButtons(view);
        return view;
    }

    private void setButtons(View view) {
        buttons = new ArrayList();
        final Button button1 = (Button) view.findViewById(R.id.Button1);
        buttons.add(button1);
        final Button button2 = (Button) view.findViewById(R.id.Button2);
        buttons.add(button2);
        final Button button3 = (Button) view.findViewById(R.id.Button3);
        buttons.add(button3);
        final Button button4 = (Button) view.findViewById(R.id.Button4);
        buttons.add(button4);
        final Button button5 = (Button) view.findViewById(R.id.Button5);
        buttons.add(button5);
        final Button button6 = (Button) view.findViewById(R.id.Button6);
        buttons.add(button6);

        setActive(button1);
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

        loadGrades(buttons.indexOf(button) + 1);
    }

    private void loadGrades(int semester) {
        List<Grade> list = GradeProvider.getInstance().getSemesterGrades(getActivity(), semester);
        list.add(0, new Grade());
        GradeAdapter gradeAdapter = new GradeAdapter(getActivity(), R.layout.grade_item, list);
        gradeListView.setAdapter(gradeAdapter);
    }
}
