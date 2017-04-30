package com.whiteshadow.studentlife;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.bumptech.glide.Glide;
import com.facebook.Profile;
import com.facebook.login.LoginManager;
import com.mikepenz.fontawesome_typeface_library.FontAwesome;
import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.ProfileDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;

/**
 * Created by Incau Ionut on 13-Apr-17.
 * Contact: ionut.incau@gmail.com
 */

public class DrawerMenu {
    private static final String TAG = "DrawerMenu";
    private static Drawer drawer;
    private static ProfileDrawerItem drawerProfile;
    private static AccountHeader accountHeader;
    private static Profile profile;
    private static Bitmap profile_picture;

    public static Drawer addDrawer(final Activity activity, Toolbar toolbar) {
        profile = Profile.getCurrentProfile();
        drawerProfile = new ProfileDrawerItem().withName(profile.getName()).withIcon(profile_picture);
        final PrimaryDrawerItem share_button = new PrimaryDrawerItem().withIdentifier(1).withName(R.string.drawer_share);
        final PrimaryDrawerItem rate_button = new PrimaryDrawerItem().withIdentifier(2).withName(R.string.rate_button);
        final PrimaryDrawerItem feedback_button = new PrimaryDrawerItem().withIdentifier(3).withName(R.string.drawer_feedback);
        final PrimaryDrawerItem settings_button = new PrimaryDrawerItem().withIdentifier(4).withName(R.string.drawer_settings);
        final PrimaryDrawerItem logout_button = new PrimaryDrawerItem().withIdentifier(5).withName(R.string.drawer_logout);

        accountHeader = new AccountHeaderBuilder()
                .withSelectionListEnabled(false)
                .withActivity(activity)
                .withHeaderBackground(R.drawable.profile_background)
                .addProfiles(drawerProfile)
                .build();

        drawer = new DrawerBuilder()
                .withActivity(activity)
                .withToolbar(toolbar)
                .withActionBarDrawerToggleAnimated(true)
                .withAccountHeader(accountHeader)
                .withSelectedItem(-1)
                .addDrawerItems(
                        share_button.withIcon(FontAwesome.Icon.faw_share_alt),
                        rate_button.withIcon(FontAwesome.Icon.faw_star),
                        feedback_button.withIcon(FontAwesome.Icon.faw_envelope),
                        settings_button.withIcon(FontAwesome.Icon.faw_cog),
                        logout_button.withIcon(FontAwesome.Icon.faw_power_off)
                )
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
                        if (drawerItem == share_button) {
                            // todo: temp
                            Intent intent = new Intent(activity, com.whiteshadow.studentlife.schedule.ScheduleActivity.class);
                            activity.startActivity(intent);
                        }
                        if (drawerItem == rate_button) {

                        }
                        if (drawerItem == settings_button) {

                        }
                        if (drawerItem == feedback_button) {

                        }
                        else if (drawerItem == logout_button) {
                            LoginManager.getInstance().logOut();
                            Intent intent = new Intent(activity, com.whiteshadow.studentlife.account.LoginActivity.class);
                            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                            activity.startActivity(intent);
                        }
                        return true;
                    }
                })
                .build();

        if (profile_picture == null) loadProfilePicture(activity);

        return drawer;
    }

    private static void loadProfilePicture(final Activity activity) {
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... params) {
                try {
                    profile_picture = Glide.
                            with(activity).
                            load(profile.getProfilePictureUri(100, 100)).
                            asBitmap().
                            into(-1,-1).
                            get();
                }
                catch (Exception e) {
                    Log.e(TAG, e.getMessage());
                }
                return null;
            }

            @Override
            protected void onPostExecute(Void param) {
                accountHeader.removeProfile(drawerProfile);
                drawerProfile.withIcon(profile_picture);
                accountHeader.addProfile(drawerProfile, 0);
                accountHeader.setActiveProfile(drawerProfile);
            }
        }.execute();
    }
}
