package com.whiteshadow.studentlife.account;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.Profile;
import com.whiteshadow.studentlife.App;
import com.whiteshadow.studentlife.MainActivity;
import com.whiteshadow.studentlife.R;
import com.whiteshadow.studentlife.domain.DaoSession;
import com.whiteshadow.studentlife.domain.Grade;
import com.whiteshadow.studentlife.domain.GradeDao;
import com.whiteshadow.studentlife.domain.ScheduleDao;
import com.whiteshadow.studentlife.domain.Student;
import com.whiteshadow.studentlife.domain.StudentDao;
import com.whiteshadow.studentlife.grades.GradeProvider;
import com.whiteshadow.studentlife.schedule.ScheduleProvider;

import static com.facebook.FacebookSdk.getApplicationContext;

/**
 * Created by Incau Ionut on 04-May-17.
 * Contact: ionut.incau@gmail.com
 */

public class CreateAccountFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_create_account, container, false);
        final TextView usernameBox = (TextView) view.findViewById(R.id.usernameBox);
        final TextView passwordBox = (TextView) view.findViewById(R.id.passwordBox);
        Button continueButton = (Button) view.findViewById(R.id.saveButon);
        continueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v) {
                String username = usernameBox.getText().toString();
                String password = passwordBox.getText().toString();
                boolean valid = validateData(username, password);
                if (valid) {
                    createProfile(username);
                    createDummyData();
                    Intent intent = new Intent(getActivity(), MainActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);
                }
                else {
                    Context context = getApplicationContext();
                    CharSequence text = "Invalid username or password";
                    int duration = Toast.LENGTH_LONG;
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }
            }
        });
        return view;
    }

    private boolean validateData(String username, String password) {
        if (username.equals("iiar1396") && password.equals("johnny")) return true;
        return false;
    }

    private void createProfile(String username) {
        Profile profile = Profile.getCurrentProfile();
        Student student = new Student();
        student.setFacebookId(profile.getId());
        student.setFirstName(profile.getFirstName());
        student.setLastName(profile.getLastName());
        student.setUsername(username);
        student.setEmail("ionut.incau@gmail.com");
        student.setPhone("0751311492");
        student.setFaculty("Math and Computer Science");
        student.setUniversity("Babes-Bolyai");

        DaoSession daoSession = ((App) getActivity().getApplication()).getDaoSession();
        StudentDao studentDao = daoSession.getStudentDao();
        studentDao.insert(student);
    }

    private void createDummyData() {
        DaoSession daoSession = ((App) getActivity().getApplication()).getDaoSession();

        ScheduleDao scheduleDao = daoSession.getScheduleDao();
        ScheduleProvider.getInstance().addDummyData(scheduleDao);

        GradeDao gradeDao = daoSession.getGradeDao();
        GradeProvider.getInstance().addDummyData(gradeDao);
    }
}
