package com.whiteshadow.studentlife.account;

import android.app.Activity;
import android.os.Bundle;

import com.whiteshadow.studentlife.R;

public class LoginActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        if (savedInstanceState == null) {
            getFragmentManager()
                    .beginTransaction()
                    .add(R.id.container_login, new LoginFragment())
                    .commit();
        }
    }
}
