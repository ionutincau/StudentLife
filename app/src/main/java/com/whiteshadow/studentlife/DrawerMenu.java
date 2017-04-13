package com.whiteshadow.studentlife;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.facebook.login.LoginManager;
import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.ProfileDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IProfile;

/**
 * Created by ionut on 13-Apr-17.
 */

public class DrawerMenu {


    public DrawerMenu() {

    }

    public static Drawer addDrawer(final Activity activity, Toolbar toolbar) {
        final PrimaryDrawerItem feedback_button = new PrimaryDrawerItem().withIdentifier(1).withName(R.string.drawer_feedback);
        final PrimaryDrawerItem settings_button = new PrimaryDrawerItem().withIdentifier(2).withName(R.string.drawer_settings);
        final PrimaryDrawerItem logout_button = new PrimaryDrawerItem().withIdentifier(3).withName(R.string.drawer_logout);

        Drawer drawer = new DrawerBuilder()
                .withActivity(activity)
                .withToolbar(toolbar)
                .addDrawerItems(
                        feedback_button,
                        settings_button,
                        logout_button
                )
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
                        if (drawerItem == settings_button) {

                        }
                        if (drawerItem == feedback_button) {

                        }
                        else if (drawerItem == logout_button) {
                            LoginManager.getInstance().logOut();
                            Intent intent = new Intent(activity, com.whiteshadow.studentlife.account.LoginActivity.class);
                            activity.startActivity(intent);
                        }
                        return true;
                    }
                })
                .build();
        return drawer;
    }
/*
    private AccountHeader getHeader(final Activity activity) {
        AccountHeader headerResult = new AccountHeaderBuilder()
                .withActivity(activity)
                .withHeaderBackground(R.drawable.header)
                .addProfiles(
                        new ProfileDrawerItem().withName("Mike Penz").withEmail("mikepenz@gmail.com").withIcon(activity.getResources().getDrawable(R.drawable.profile))
                )
                .withOnAccountHeaderListener(new AccountHeader.OnAccountHeaderListener() {
                    @Override
                    public boolean onProfileChanged(View view, IProfile profile, boolean currentProfile) {
                        return false;
                    }
                })
                .build();
    }*/
}
