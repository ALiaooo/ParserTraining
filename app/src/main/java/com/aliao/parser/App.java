package com.aliao.parser;

import android.app.Application;
import android.content.Context;

/**
 * Created by 丽双 on 2015/6/4.
 */
public class App extends Application {
    private static Context sContext;

    public App(){
        sContext = this;
    }

    public static Context getContext(){
        return sContext;
    }
}
