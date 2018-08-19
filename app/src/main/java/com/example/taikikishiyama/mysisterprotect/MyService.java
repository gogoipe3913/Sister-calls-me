package com.example.taikikishiyama.mysisterprotect;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import java.util.Timer;
import java.util.TimerTask;


//このクラスはBackground処理で使えそう？

public class MyService extends Service {

    final static String TAG = "MyService";
    final int INTERVAL_PERIOD = 5000;
    Timer timer = new Timer();
    public int wifiJadge;

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG, "onStartCommand");

        timer.scheduleAtFixedRate(new TimerTask(){
            @Override
            public void run() {

                Log.d(TAG, "Hello!");
            }
        }, 0, INTERVAL_PERIOD);

        return wifiJadge;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if(timer != null){
            timer.cancel();
        }
        Log.d(TAG, "onDestroy");
    }

}