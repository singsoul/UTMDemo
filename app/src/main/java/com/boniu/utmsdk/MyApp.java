package com.boniu.utmsdk;

import android.app.Application;

import com.weidai.lib.tracker.Tracker;
import com.weidai.lib.tracker.lifecycle.ITrackerContext;
import com.weidai.lib.tracker.model.TrackerMode;

public class MyApp extends Application implements ITrackerContext {
    private String APPNAME = "";

    @Override
    public void onCreate() {
        super.onCreate();
        //设置应⽤渠道名，⼀般定义在AndroidManifest.xml中

        Tracker.INSTANCE.channelId = "mkbd";
        Tracker.INSTANCE.projectName = "bn_" + APPNAME ;//bn_ 加项目的appname，找后台要
        Tracker.INSTANCE.setMode(TrackerMode.DEBUG_TRACK);
        Tracker.INSTANCE.initialize(this);
    }
}
