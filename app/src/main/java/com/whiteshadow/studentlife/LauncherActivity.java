package com.whiteshadow.studentlife;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.facebook.Profile;
import com.whiteshadow.studentlife.account.LoginActivity;

/**
 * Created by Incau Ionut on 14-Apr-17.
 * Contact: ionut.incau@gmail.com
 */

public class LauncherActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent;
        if (Profile.getCurrentProfile() != null) {
            intent = new Intent(this, MainActivity.class);
        }
        else {
            intent = new Intent(this, LoginActivity.class);
        }
        startActivity(intent);
        finish();
    }
}
