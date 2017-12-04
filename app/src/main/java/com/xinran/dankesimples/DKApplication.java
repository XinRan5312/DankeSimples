package com.xinran.dankesimples;

import android.app.Application;


/**
 * Created by houqixin on 2017/11/21.
 */

public class DKApplication extends Application {

    private static Application mApplicationContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mApplicationContext=this;
    }

    public static Application getApplication(){

        return mApplicationContext;
    }
}
