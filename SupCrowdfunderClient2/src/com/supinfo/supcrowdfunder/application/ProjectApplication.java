package com.supinfo.supcrowdfunder.application;

import android.app.Application;
import android.content.res.Resources;

public class ProjectApplication extends Application {

    private static ProjectApplication instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }

    public static Resources getApplicationResources() {
        return instance.getResources();
    }
}
