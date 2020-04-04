package com.example.hello4.fragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelStoreOwner;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.hello4.R;
import com.example.hello4.WaitingActivity;

public class BottomActivity extends AppCompatActivity {

    private MediaPlayer music;
    private int soundID;
    private SoundPool soundPool;

    private Button mBtnMoveNow;
    private Button mBtnAutoCharge;
    private Button mBtnMap;
    private Button mBtnBooking;
    private Button mBtnManual;

    private Button mBtnHome;
    private Button mBtnDevice;
    private Button mBtnFeedback;
    private Button mBtnUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBtnMoveNow = findViewById(R.id.btn_move);
        mBtnAutoCharge =  findViewById(R.id.btn_auto);
        mBtnMap =  findViewById(R.id.btn_map);
        mBtnBooking = findViewById(R.id.btn_booking);
        mBtnManual =  findViewById(R.id.btn_manual);
        mBtnHome =  findViewById(R.id.btn_home);
        mBtnDevice = findViewById(R.id.btn_device);
        mBtnFeedback =  findViewById(R.id.btn_feedback);
        mBtnUser =  findViewById(R.id.btn_user);
        Toast.makeText(BottomActivity.this,"Moving", Toast.LENGTH_SHORT).show();
    }

    private class OnClick implements View.OnClickListener{
        @Override
        public void onClick(View v){

            Intent intent = null;
            switch (v.getId()){
                case R.id.btn_move:
                    OnMove();
            }
        }
    }

    private void OnMove(){
        playSound();
        Toast.makeText(BottomActivity.this,"Moving", Toast.LENGTH_SHORT).show();
    }

    private void PlayMusic(int MusicId) {
        music = MediaPlayer.create(this, MusicId);
        music.start();
    }
    @SuppressLint("NewApi")
    private void initSound() {
        soundPool = new SoundPool.Builder().build();
        soundID = soundPool.load(this, R.raw.jianpan, 1);
    }
    private void playSound() {
        soundPool.play(
                soundID,
                0.5f,      //左耳道音量【0~1】
                0.5f,      //右耳道音量【0~1】
                0,         //播放优先级【0表示最低优先级】
                0,         //循环模式【0表示循环一次，-1表示一直循环，其他表示数字+1表示当前数字对应的循环次数】
                1          //播放速度【1是正常，范围从0~2】
        );
    }
}
