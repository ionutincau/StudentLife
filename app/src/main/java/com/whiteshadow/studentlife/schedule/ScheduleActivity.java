package com.whiteshadow.studentlife.schedule;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.whiteshadow.studentlife.R;

/**
 * Created by Incau Ionut on 30-Apr-17.
 * Contact: ionut.incau@gmail.com
 */

public class ScheduleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        setContentView(R.layout.activity_schedule);
        if (savedInstanceState == null) {
            getFragmentManager()
                    .beginTransaction()
                    .add(R.id.container_schedule, new ScheduleFragment())
                    .commit();
        }
    }
}
