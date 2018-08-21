package com.example.wuzhiming.xutilsdemo;

import android.app.Application;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

/**
 * Created by wuzhiming on 18/8/21.
 */

public class MyApp extends Application{



    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);
    }



}
