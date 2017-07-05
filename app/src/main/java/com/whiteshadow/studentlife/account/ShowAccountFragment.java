package com.whiteshadow.studentlife.account;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.facebook.Profile;
import com.whiteshadow.studentlife.App;
import com.whiteshadow.studentlife.R;
import com.whiteshadow.studentlife.domain.DaoSession;
import com.whiteshadow.studentlife.domain.Student;
import com.whiteshadow.studentlife.domain.StudentDao;

/**
 * Created by Incau Ionut on 04-May-17.
 * Contact: ionut.incau@gmail.com
 */

public class ShowAccountFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_show_account, container, false);

        Button changeButton = (Button) view.findViewById(R.id.changeButon);
        changeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity()
                        .getFragmentManager()
                        .beginTransaction()
                        .replace(R.id.container_account, new EditAccountFragment())
                        .commit();
            }
        });

        TextView name = (TextView) view.findViewById(R.id.name);
        TextView username = (TextView) view.findViewById(R.id.username);
        TextView email = (TextView) view.findViewById(R.id.email);
        TextView phone = (TextView) view.findViewById(R.id.phone);
        TextView university = (TextView) view.findViewById(R.id.university);
        TextView faculty = (TextView) view.findViewById(R.id.faculty);

        DaoSession daoSession = ((App) getActivity().getApplication()).getDaoSession();
        StudentDao studentDao = daoSession.getStudentDao();
        Student student = studentDao.queryBuilder().list().get(0);

        name.setText("Name: " + student.getLastName() + " " + student.getFirstName());
        username.setText("Username: " + student.getUsername());
        email.setText("Email: " + student.getEmail());
        phone.setText("Phone: " + student.getPhone());
        university.setText("University: " + student.getUniversity());
        faculty.setText("Faculty: " + student.getFaculty());

        return view;
    }
}
