package com.example.hello4;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class WaitingActivity extends AppCompatActivity {

    private Button mBtnmove_now;
    private Button auto_charge;
    private Button map;
    private Button booking;
    private Button manual;

    private Button home;
    private Button device;
    private Button feedback;
    private Button user;

    private SoundPool soundPool;
    private int soundID;
    private MediaPlayer music;

    private Toolbar mToolbar;

    private Calendar calendar;  //日期类

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_waiting);
        initSound();
        initToolBar();//初始化toolbar

        mBtnmove_now = ((Button) findViewById(R.id.btn_move));
        mBtnmove_now.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSound();
                Toast.makeText(WaitingActivity.this,"Moving", Toast.LENGTH_SHORT).show();
            }
        });
        auto_charge = ((Button) findViewById(R.id.btn_auto));
        auto_charge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSound();
                Toast.makeText(WaitingActivity.this, "auto_charge", Toast.LENGTH_SHORT).show();
            }
        });
        map = ((Button) findViewById(R.id.btn_map));
        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSound();
                Intent intent=new Intent(WaitingActivity.this,MoveActivity.class);
                startActivity(intent);
                Toast.makeText(WaitingActivity.this, "Mapping", Toast.LENGTH_SHORT).show();
            }
        });
        booking = (Button) findViewById(R.id.btn_booking);
        booking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int hourOfDay;
                Calendar calendar = Calendar.getInstance();
                hourOfDay = calendar.get(Calendar.HOUR);
                int minute = calendar.get(Calendar.MINUTE);
                playSound();
                TimePickerDialog pickerDialog = new TimePickerDialog(WaitingActivity.this, new TimePickerDialog.OnTimeSetListener() {

                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        // TODO Auto-generated method stub
                        final String[] weekday = new String[]{"Mon","Tues","Wed","Thur","Fri","Sat","Sun"};
                        boolean[] begin = new boolean[]{false,false,false,false,false,false,false};
                        final List<String> choose = new ArrayList<>();
                        androidx.appcompat.app.AlertDialog.Builder builder = new androidx.appcompat.app.AlertDialog.Builder(WaitingActivity.this);
                        builder.setTitle("Please select a week");
                        builder.setMultiChoiceItems(weekday, begin, new DialogInterface.OnMultiChoiceClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                                if(isChecked){
                                    choose.add(weekday[which]);
                                }else{
                                    choose.remove(weekday[which]);
                                }

                            }
                        });
                        builder.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                            }
                        });
                        builder.setNegativeButton("Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(WaitingActivity.this, "You chooce"+choose.toString()+"to start move", Toast.LENGTH_SHORT).show();
                            }
                        }).show();
                        Toast.makeText(WaitingActivity.this, "Will start at "+hourOfDay + ":" + minute, Toast.LENGTH_SHORT).show();
                    }
                }, hourOfDay, minute, true);
                pickerDialog.show();

            }
        });


        home = (Button) findViewById(R.id.btn_home);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(WaitingActivity.this,WaitingActivity.class);
                startActivity(intent);
                Toast.makeText(WaitingActivity.this, "home", Toast.LENGTH_SHORT).show();
            }
        });
        device = (Button) findViewById(R.id.btn_device);
        device.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(WaitingActivity.this,"device",Toast.LENGTH_SHORT).show();
            }
        });
        feedback = (Button) findViewById(R.id.btn_feedback);
        feedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(WaitingActivity.this,"feedback",Toast.LENGTH_SHORT).show();
            }
        });
        user = (Button) findViewById(R.id.btn_user);
        user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(WaitingActivity.this, "user", Toast.LENGTH_SHORT).show();
            }
        });
        manual = (Button) findViewById(R.id.btn_manual);
        manual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSound();
                final EditText et = new EditText(WaitingActivity.this);
                new AlertDialog.Builder(WaitingActivity.this).setTitle("Password")
                        .setIcon(android.R.drawable.sym_def_app_icon)
                        .setView(et)
                        .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                //按下确定键后的事件
                                String passwd = et.getText().toString();
                                if(passwd.equals("0000")){
                                    Intent intent=new Intent(WaitingActivity.this,OperaterActivity.class);
                                    startActivity(intent);
                                }
                                else{
                                    Toast.makeText(getApplicationContext(),"Password error",Toast.LENGTH_LONG).show();
                                }
                            }
                        }).setNegativeButton("cancel",null).show();
            }
        });
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

    private void initToolBar() {
        Toolbar mToolbar = findViewById(R.id.toolbar_base);
        mToolbar.setTitle("");//这样设置的话，自带的标题就不会显示
        //设置自定义的标题（居中）
        TextView toolBarTitle = mToolbar.findViewById(R.id.toolbarTitle);
        toolBarTitle.setText("robbay mover");
        setSupportActionBar(mToolbar);//由于toolbar只是一个普通控件，我们将ToolBar设置为ActionBar
        //设置导航图标要在setSupportActionBar方法之后
        //mToolbar.setNavigationIcon(null);//设置为空的话，就会不显示左侧的图标
        //对NavigationIcon添加点击
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        //添加menu 菜单点击事件
        mToolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {

                switch (item.getItemId()){
                    case R.id.action_save:
                        Toast.makeText(WaitingActivity.this,"保存",Toast.LENGTH_SHORT).show();
                        break;
                }
                return true;
            }
        });

    }

    @Override
    public boolean onCreatePanelMenu(int featureId, Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_popup_menu, menu);//toolbar添加menu菜单
        return true;
    }
    
}


