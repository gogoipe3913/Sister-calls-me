package com.example.taikikishiyama.mysisterprotect;

/**
 * Created by Taiki.Kishiyama on 2017/09/24.
 */

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.content.ContextCompat;
import android.view.View;

import com.github.bassaer.chatmessageview.models.Message;
import com.github.bassaer.chatmessageview.models.User;
import com.github.bassaer.chatmessageview.views.ChatView;

import java.util.Random;


public class DisagreeActivity extends Activity {


    private ChatView mChatView;
    private SoundPool mSoundPool;
    private int mSoundId;

    @Override
    protected void onResume() {
        super.onResume();
        // 予め音声データを読み込む
        mSoundPool = new SoundPool(1, AudioManager.STREAM_MUSIC, 0);
        mSoundId = mSoundPool.load(getApplicationContext(), R.raw.syuponsound, 0);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disagree);

        //User id
        int myId = 0;
        //User icon
        Bitmap myIcon = BitmapFactory.decodeResource(getResources(), R.drawable.face_2);
        //User name
        String myName = "兄さん";

        int yourId = 1;
        Bitmap yourIcon = BitmapFactory.decodeResource(getResources(), R.drawable.face_1);
        String yourName = "紗霧";

        final User me = new User(myId, myName, myIcon);
        final User you = new User(yourId, yourName, yourIcon);


        mChatView = (ChatView)findViewById(R.id.chat_view);

        //Set UI parameters if you need
        mChatView.setRightBubbleColor(ContextCompat.getColor(this, R.color.green500));
        mChatView.setLeftBubbleColor(Color.WHITE);
        mChatView.setBackgroundColor(ContextCompat.getColor(this, R.color.blueGray500));
        mChatView.setSendButtonColor(ContextCompat.getColor(this, R.color.cyan900));
        mChatView.setSendIcon(R.drawable.ic_action_send);
        mChatView.setRightMessageTextColor(Color.WHITE);
        mChatView.setLeftMessageTextColor(Color.BLACK);
        mChatView.setUsernameTextColor(Color.WHITE);
        mChatView.setSendTimeTextColor(Color.WHITE);
        mChatView.setDateSeparatorColor(Color.WHITE);
        mChatView.setInputTextHint("new message...");
        mChatView.setMessageMarginTop(5);
        mChatView.setMessageMarginBottom(5);



        new Handler().postDelayed(new Runnable() {
            // Runnable型のインスタンス化と定義
            @Override
            public void run() {
                mSoundPool.play(mSoundId, 1.0F, 1.0F, 0, 0, 1.0F);

                Message message1 = new Message.Builder()
                        .setUser(you) // Sender
                        .setRightMessage(false) // This message Will be shown left side.
                        .setMessageText("兄さん！") //Message contents
                        .build();
                mChatView.receive(message1); // Will be shown left side
            }
        }, 1000);

        new Handler().postDelayed(new Runnable() {
            // Runnable型のインスタンス化と定義
            @Override
            public void run() {
                mSoundPool.play(mSoundId, 1.0F, 1.0F, 0, 0, 1.0F);

                Message message2 = new Message.Builder()
                        .setUser(you) // Sender
                        .setRightMessage(false) // This message Will be shown left side.
                        .setMessageText("wi-fi繋がないで重いの見ちゃダメ！") //Message contents
                        .build();
                mChatView.receive(message2); // Will be shown left side
            }
        }, 3000);

        new Handler().postDelayed(new Runnable() {
            // Runnable型のインスタンス化と定義
            @Override
            public void run() {
                mSoundPool.play(mSoundId, 1.0F, 1.0F, 0, 0, 1.0F);

                Message message3 = new Message.Builder()
                        .setUser(you) // Sender
                        .setRightMessage(false) // This message Will be shown left side.
                        .setMessageText("約束守ってくれない兄さんなんて嫌い！！！") //Message contents
                        .build();
                mChatView.receive(message3); // Will be shown left side
            }
        }, 5000);

        ////////////////////////////////////////////////////////////////////
        //        以上が通知画面後の3メッセージ分です。                   //
        //        以下が自分の趣味で導入したメッセージランダム返信機能と  //
        //         "yamadaerufu"か"erufu"                                 //
        // "山田エルフ"か"えるふ"か"エルフ"が入力されたとき、             //
        //         一時的に山田エルフ先生アイコンに変わる裏モードです。   //
        ////////////////////////////////////////////////////////////////////


        final Random r = new Random();

        //Click Send Button
        mChatView.setOnClickSendButtonListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //new message
                Message message = new Message.Builder()
                        .setUser(me)
                        .setRightMessage(true)
                        .setMessageText(mChatView.getInputText())
                        .hideIcon(true)
                        .build();
                //Set to chat view
                mChatView.send(message);
                //Reset edit text
                mChatView.setInputText("");
                //入力されたメッセージをlogで確認します。
                System.out.println(message.getMessageText() );

                //このifの部分が山田エルフ裏モードです。
                if(message.getMessageText().equals("えるふ")
                        ||message.getMessageText().equals("エルフ")
                        ||message.getMessageText().equals("山田エルフ")
                        ||message.getMessageText().equals("yamadaerufu")
                        ||message.getMessageText().equals("erufu")){

                    int yourId = 1;
                    Bitmap yourIcon = BitmapFactory.decodeResource(getResources(), R.drawable.face_3);
                    String yourName = "エルフ";
                    final User you = new User(yourId, yourName, yourIcon);
                    new Handler().postDelayed(new Runnable() {
                        // Runnable型のインスタンス化と定義
                        @Override
                        public void run() {
                            mSoundPool.play(mSoundId, 1.0F, 1.0F, 0, 0, 1.0F);
                    Message erufu = new Message.Builder()
                            .setUser(you) // Sender
                            .setRightMessage(false) // This message Will be shown left side.
                            .setMessageText("あんた、私のお婿さん候補なんだからね！") //Message contents
                            .build();
                    mChatView.receive(erufu); // Will be shown left side
                        }
                    }, 1000);

                }
                //山田エルフ裏モード　ここまで


                //ここからがランダム返信用のプログラムです。
                //乱数をセットします（最大値50で生成します。）
                int n = r.nextInt(50);

                if(message.getMessageText().equals("えるふ")
                        ||message.getMessageText().equals("エルフ")
                        ||message.getMessageText().equals("山田エルフ")
                        ||message.getMessageText().equals("yamadaerufu")
                        ||message.getMessageText().equals("erufu")){
                    n = 100;
                }

                System.out.println(n);
                if(0<= n && n < 10) {
                    //ランダム返信パターン1
                    new Handler().postDelayed(new Runnable() {
                        // Runnable型のインスタンス化と定義
                        @Override
                        public void run() {
                            mSoundPool.play(mSoundId, 1.0F, 1.0F, 0, 0, 1.0F);

                            //Receive message
                    final Message receivedMessage = new Message.Builder()
                            .setUser(you)
                            .setRightMessage(false)
                            .setMessageText("約束守ってくれない兄さんなんて嫌い！！！")
                            .build();
                    mChatView.receive(receivedMessage); // Will be shown left side
                        }
                    }, 1000);
                }else if(10 <= n && n < 20){
                    //ランダム返信パターン2
                    new Handler().postDelayed(new Runnable() {
                        // Runnable型のインスタンス化と定義
                        @Override
                        public void run() {
                            mSoundPool.play(mSoundId, 1.0F, 1.0F, 0, 0, 1.0F);

                            final Message receivedMessage = new Message.Builder()
                            .setUser(you)
                            .setRightMessage(false)
                            .setMessageText("今度から絶対気を付けてね...わかった？　兄さん？？")
                            .build();
                    mChatView.receive(receivedMessage); // Will be shown left side
                        }
                    }, 1000);
                }else if(20 <= n && n < 30){
                    //ランダム返信パターン3
                    new Handler().postDelayed(new Runnable() {
                        // Runnable型のインスタンス化と定義
                        @Override
                        public void run() {
                            mSoundPool.play(mSoundId, 1.0F, 1.0F, 0, 0, 1.0F);

                            final Message receivedMessage = new Message.Builder()
                            .setUser(you)
                            .setRightMessage(false)
                            .setMessageText("兄さんのバカ！にぶちん！！ラノベ主人公～～～！！！！！")
                            .build();
                    mChatView.receive(receivedMessage); // Will be shown left side
                        }
                    }, 1000);
                }else if (30 <= n && n < 40){
                    //ランダム返信パターン4
                    new Handler().postDelayed(new Runnable() {
                        // Runnable型のインスタンス化と定義
                        @Override
                        public void run() {
                            mSoundPool.play(mSoundId, 1.0F, 1.0F, 0, 0, 1.0F);

                            final Message receivedMessage = new Message.Builder()
                            .setUser(you)
                            .setRightMessage(false)
                            .setMessageText("兄さんは一生wifi繋げず重いの見ちゃダメ。わかった？")
                            .build();
                    mChatView.receive(receivedMessage); // Will be shown left side
                        }
                    }, 1000);
                }else if (40 <= n && n <= 50){
                    //ランダム返信パターン5
                    new Handler().postDelayed(new Runnable() {
                        // Runnable型のインスタンス化と定義
                        @Override
                        public void run() {
                            mSoundPool.play(mSoundId, 1.0F, 1.0F, 0, 0, 1.0F);

                            final Message receivedMessage = new Message.Builder()
                            .setUser(you)
                            .setRightMessage(false)
                            .setMessageText("兄さんなんて大嫌い")
                            .build();
                    mChatView.receive(receivedMessage); // Will be shown left side
                        }
                    }, 1000);
                }

            }

        });

    }
}
