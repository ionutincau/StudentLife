package com.whiteshadow.studentlife;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.facebook.Profile;
import com.mikepenz.fontawesome_typeface_library.FontAwesome;
import com.mikepenz.iconics.IconicsDrawable;
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

        Drawable menu_icon = new IconicsDrawable(this)
                .icon(FontAwesome.Icon.faw_bars)
                .color(Color.WHITE)
                .sizeDp(48);
        toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(menu_icon);
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
