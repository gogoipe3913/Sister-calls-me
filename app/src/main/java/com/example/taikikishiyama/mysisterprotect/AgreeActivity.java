package com.example.taikikishiyama.mysisterprotect;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

public class AgreeActivity extends Activity {


private void playFromMediaPlayer1() {
    MediaPlayer mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.sagiricall);
    mediaPlayer.start();
}

    private void playFromMediaPlayer2() {
        MediaPlayer mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.sagiriend);
        mediaPlayer.start();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agree);

        new Handler().postDelayed(new Runnable() {
            // Runnable型のインスタンス化と定義
            @Override
            public void run() {

                playFromMediaPlayer1();

            }
        }, 1000);

        new Handler().postDelayed(new Runnable() {
            // Runnable型のインスタンス化と定義
            @Override
            public void run() {

                playFromMediaPlayer2();

            }
        }, 9000);

    }
    public void onfinishButton(View v){
        moveTaskToBack (true);
    }
}
