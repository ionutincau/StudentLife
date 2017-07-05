package com.whiteshadow.studentlife.account;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.whiteshadow.studentlife.App;
import com.whiteshadow.studentlife.R;
import com.whiteshadow.studentlife.domain.DaoSession;
import com.whiteshadow.studentlife.domain.Student;
import com.whiteshadow.studentlife.domain.StudentDao;

/**
 * Created by Incau Ionut on 04-May-17.
 * Contact: ionut.incau@gmail.com
 */

public class EditAccountFragment extends Fragment {
    private EditText firstName;
    private EditText lastName;
    private EditText email;
    private EditText phone;
    private Student student;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_edit_account, container, false);

        Button continueButton = (Button) view.findViewById(R.id.saveButon);
        continueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                save();
                getActivity()
                        .getFragmentManager()
                        .beginTransaction()
                        .replace(R.id.container_account, new ShowAccountFragment())
                        .commit();
            }
        });

        firstName = (EditText) view.findViewById(R.id.firstNameBox);
        lastName = (EditText) view.findViewById(R.id.lastNameBox);
        email = (EditText) view.findViewById(R.id.emailBox);
        phone = (EditText) view.findViewById(R.id.phoneBox);

        DaoSession daoSession = ((App) getActivity().getApplication()).getDaoSession();
        StudentDao studentDao = daoSession.getStudentDao();
        student = studentDao.queryBuilder().list().get(0);

        firstName.setText(student.getFirstName());
        lastName.setText(student.getLastName());
        email.setText(student.getEmail());
        phone.setText(student.getPhone());

        return view;
    }

    private void save() {
        student.setFirstName(firstName.getText().toString());
        student.setLastName(lastName.getText().toString());
        student.setEmail(email.getText().toString());
        student.setPhone(phone.getText().toString());

        DaoSession daoSession = ((App) getActivity().getApplication()).getDaoSession();
        StudentDao studentDao = daoSession.getStudentDao();
        studentDao.update(student);
    }
}
