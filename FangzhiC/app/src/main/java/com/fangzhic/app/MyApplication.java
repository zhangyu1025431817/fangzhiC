package com.fangzhic.app;

import android.app.Application;
import android.content.Context;

/**
 * Created by smacr on 2016/12/27.
 */

public class MyApplication extends Application {
    private static Context mContext ;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
    }

    public static Context getContext(){
        return mContext;
    }
}
