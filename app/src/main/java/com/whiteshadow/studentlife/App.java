package com.whiteshadow.studentlife;

import android.app.Application;

import com.whiteshadow.studentlife.schedule.DaoMaster;
import com.whiteshadow.studentlife.schedule.DaoSession;

import org.greenrobot.greendao.database.Database;

/**
 * Created by Incau Ionut on 30-Apr-17.
 * Contact: ionut.incau@gmail.com
 */

public class App extends Application {

    private DaoSession daoSession;

    @Override
    public void onCreate() {
        super.onCreate();

        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, "studentlife_db");
        Database db = helper.getWritableDb();
        daoSession = new DaoMaster(db).newSession();
    }

    public DaoSession getDaoSession() {
        return daoSession;
    }

}
