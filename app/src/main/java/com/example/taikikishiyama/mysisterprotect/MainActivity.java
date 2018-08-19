package com.example.taikikishiyama.mysisterprotect;


import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import java.util.List;


public class MainActivity extends AppCompatActivity {

    String appName;
//    Timer timer ;
//    private int wifiJadge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        int wifiJadge = 0;
        if (wifiJadge == 0) {
//      ACTIVITY_SERVICEから起動中のアプリを取得
            ActivityManager activityManager = (ActivityManager) this.getSystemService(ACTIVITY_SERVICE);
            List<ActivityManager.RunningAppProcessInfo> procInfos = activityManager.getRunningAppProcesses();
            appName = procInfos.get(0).processName;
//          取得したプロセスの一番はじめの要素をappNameに格納
        }


//      wifiを取得しているかの処理↓
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.getType() == ConnectivityManager.TYPE_WIFI) {
            // シンプルな状態を取得
            NetworkInfo.State networkState = networkInfo.getState();
            System.out.println("wifiオフ！！！！");
            //wifiJadge = "off";
        }else {
//            wifiJadge = "on";
            System.out.println("wifiオン！！！！");
        }

        ////////////////////////////////////////////////////////////////
        //  以下がbackgroundでもgoolemapを動かしたら探知するコードです//
        ////////////////////////////////////////////////////////////////

        final ActivityManager activityManager = (ActivityManager) this.getSystemService(ACTIVITY_SERVICE);
        final String Jadge = "com.google.android.apps.maps";
        final Handler handler = new Handler();
        final Runnable r = new Runnable() {
            int count = 0;
            @Override
            public void run() {
                // UIスレッド
                count++ ;
                if (count > 2147000000) { // 2147000000回実行したら終了（ほぼ68年ループ）
                    return;
                }
                final List<ActivityManager.RunningAppProcessInfo> procInfos = activityManager.getRunningAppProcesses();
                    System.out.println(count+ "回目のループ開始");
                    for(int idx = 0; idx < procInfos.size() ;idx ++) {
                        System.out.println(idx + "idx. for処理を開始");
                        final String Jadge = "com.google.android.apps.maps";
                        String backApp = String.valueOf(procInfos.get(idx).processName);
                        if (backApp.equals(Jadge)) {

                            System.out.println("trueになりました！！！");
                            count = 2147483000;  //ループ終了

                            Intent intent = new Intent(getApplication(), NotificationActivity.class);
                            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_SINGLE_TOP);
                            startActivity(intent);

                            //一番下の private int getMyAppId()と連動して使います。

                            int id = getMyAppId();
                            if (id > 0) {
                                ActivityManager activityManager = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
                                activityManager.moveTaskToFront(id, ActivityManager.MOVE_TASK_WITH_HOME);
                            }


                    } else {
                            System.out.println("falseになりました");
                            System.out.println(idx +"idx. for処理を終了");
                        }
                    }
                System.out.println(count+ "回目のループ終了");

                handler.postDelayed(this, 1000);
            }

        };
        handler.post(r);

        //////////////////////////////////////////////////////////
        //                      ここまで                        //
        //////////////////////////////////////////////////////////

    }

//getMyAppIDが今foreにいるかbackにいるかを探知します。
    private int getMyAppId() {
        int id = -1;
        ActivityManager activityManager =  (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);

        //ここらへんでNullPointerExceptionエラーが出てうまくいきませんでした。
        List<ActivityManager.RunningTaskInfo> recentTasks = activityManager.getRunningTasks(Integer.MAX_VALUE);


        for (int i = 0; i < recentTasks.size(); i++) {

            if (recentTasks.get(i).baseActivity.getPackageName().equals(this.getPackageName())) {
                return recentTasks.get(i).id;
            }
        }

        return id;
    }



}




