package com.example.hello4;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsoluteLayout;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Timer;
import java.util.TimerTask;

import static java.awt.font.TextAttribute.WIDTH;

public class MoveActivity extends AppCompatActivity {
    private Button mBtnmove_now;
    private Button auto_charge;
    private Button map;
    private Button booking;
    private Button manual;

    private Button home;
    private Button device;
    private Button feedback;
    private Button user;

    private ImageView image;
    private AbsoluteLayout.LayoutParams params;
    private int count = 0;
    final Timer timer = new Timer();                    //创建一个定时器对象
    TimerTask task = new TimerTask(){
        @Override
        public void run() {
            count+=1;
            params = (AbsoluteLayout.LayoutParams) image.getLayoutParams();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        //canvas = this.surfaceHolder.lockCanvas();

        home = (Button) findViewById(R.id.btn_home);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MoveActivity.this,WaitingActivity.class);
                startActivity(intent);
                Toast.makeText(MoveActivity.this, "home", Toast.LENGTH_SHORT).show();
            }
        });


        //timer.schedule(task, 1000);
        final Handler handler = new Handler();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                if (count <= 30){
                    /*执行一段逻辑*/
                    // add your code;
                    ImageView image = ((ImageView) findViewById(R.id.robot));;
                    AbsoluteLayout.LayoutParams params = (AbsoluteLayout.LayoutParams) image.getLayoutParams();
                    params.x = params.x -20;
                    image.setLayoutParams(params);
                    handler.postDelayed(this,500);//延时五百毫秒，再次执行这个runnable，如果isRegister为false了就停止执行了
                    count += 1;
                }
            }
        };

        //然后在你初次调起这个延时逻辑的地方调用以下语句：
        handler.postDelayed(runnable,500);//延时五百毫秒，执行runnable


        /*
        timer.schedule(task,0,1000);                //启动定时器
        ImageView image = ((ImageView) findViewById(R.id.robot));
        AbsoluteLayout.LayoutParams params = (AbsoluteLayout.LayoutParams) image.getLayoutParams();
        params.x = 60;
        params.y = 40;
        image.setLayoutParams(params);
        */
    }
}



