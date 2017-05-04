package com.whiteshadow.studentlife;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.facebook.Profile;
import com.mikepenz.materialdrawer.Drawer;

/**
 * Created by Incau Ionut on 12-Apr-17.
 * Contact: ionut.incau@gmail.com
 */

public class MainActivity extends AppCompatActivity {
    private Profile profile;
    private Toolbar toolbar;
    private Drawer drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        profile = Profile.getCurrentProfile();
        if (profile == null) {
            Intent intent = new Intent(this, com.whiteshadow.studentlife.account.LoginActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
            startActivity(intent);
        }

        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getFragmentManager()
                    .beginTransaction()
                    .add(R.id.container_main, new MainFragment())
                    .commit();
        }

        toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
    }

    @Override
    protected void onStart() {
        super.onStart();
        drawer = DrawerMenu.addDrawer(this, toolbar);
    }

    @Override
    public void onBackPressed () {
        if (drawer != null && drawer.isDrawerOpen()) {
            drawer.closeDrawer();
        }
        else {
            super.onBackPressed();
        }
    }
}
