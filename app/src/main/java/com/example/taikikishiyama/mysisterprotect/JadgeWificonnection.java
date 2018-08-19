package com.example.taikikishiyama.mysisterprotect;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

/**
 * Created by Taiki.Kishiyama on 2017/09/24.
 */

//今このクラス使ってないっす。

public class JadgeWificonnection extends AppCompatActivity {

    String appName;

    protected void youtube() {





        Log.w("メッセージ", "アリ寄りのアリ");
        this.finish();

    }
//
      public static void startAlarm(Context context) {
      // 実行するサービスを指定する
      PendingIntent pendingIntent = PendingIntent.getService(context, 0,
                new Intent(context, JadgeWificonnection.class),
                PendingIntent.FLAG_UPDATE_CURRENT);

        // 10秒毎にサービスの処理を実行する
        AlarmManager am = (AlarmManager) context
                .getSystemService(Context.ALARM_SERVICE);
        am.setRepeating(AlarmManager.ELAPSED_REALTIME_WAKEUP,
                SystemClock.elapsedRealtime(), 10 * 1000, pendingIntent);
      }
//      Backgroundにいる時、処理を10秒に一回実行する


}