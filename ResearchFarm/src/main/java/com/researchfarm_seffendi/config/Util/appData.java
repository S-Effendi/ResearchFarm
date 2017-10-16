package com.researchfarm_seffendi.config.Util;

import android.app.Application;
import android.content.Context;

/**
 * Created by Suzanne Effendi on 2017/09/07.
 */
public class appData extends Application {

        private static Context context;
        private static appData singleton;

        @Override
        public void onCreate() {
        super.onCreate();
        appData.context = getAppContext();
        singleton = this;
        }

    public static Context getAppContext()
    {
        return appData.context;
    }
}
