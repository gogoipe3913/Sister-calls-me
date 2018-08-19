//このクラスは使用しています。
//通知画面(紗霧ちゃん画面)を表示して、ボタン操作を探知する部分です。

package com.example.taikikishiyama.mysisterprotect;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class NotificationActivity extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button agreeButton = (Button) findViewById(R.id.agreeButton);
        agreeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplication(), AgreeActivity.class);
                startActivity(intent);
            }
        });

        Button disagreeButton = (Button) findViewById(R.id.disagreeButton);
        disagreeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplication(), DisagreeActivity.class);
                startActivity(intent);
            }
        });

        }

    }

