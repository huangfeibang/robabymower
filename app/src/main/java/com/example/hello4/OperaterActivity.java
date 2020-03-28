package com.example.hello4;

import android.app.AlertDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.Calendar;

public class OperaterActivity extends AppCompatActivity {

    private Button mBtnmove_now;
    private Button auto_charge;
    private Button map;
    private Button booking;
    private Button manual;

    private Button home;
    private Button device;
    private Button feedback;
    private Button user;
    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_operator);
        initToolBar();//初始化toolbar

        mBtnmove_now = ((Button) findViewById(R.id.btn_move));
        mBtnmove_now.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(OperaterActivity.this,MoveActivity.class);
                startActivity(intent);

                //Toast.makeText(PendingActivity.this,"AutoCharge", Toast.LENGTH_SHORT).show();
            }
        });
        auto_charge = ((Button) findViewById(R.id.btn_auto));
        auto_charge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(OperaterActivity.this,"AutoCharge", Toast.LENGTH_SHORT).show();
            }
        });
        map = ((Button) findViewById(R.id.btn_map));
        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(OperaterActivity.this,MoveActivity.class);
                startActivity(intent);
                Toast.makeText(OperaterActivity.this, "Mapping", Toast.LENGTH_SHORT).show();
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
                TimePickerDialog pickerDialog = new TimePickerDialog(OperaterActivity.this, new TimePickerDialog.OnTimeSetListener() {

                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        // TODO Auto-generated method stub
                        Toast.makeText(OperaterActivity.this, "Will start at "+hourOfDay + ":" + minute, Toast.LENGTH_SHORT).show();
                    }
                }, hourOfDay, minute, true);

                pickerDialog.show();

            }
        });

        home = (Button) findViewById(R.id.btn_home);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(OperaterActivity.this,WaitingActivity.class);
                startActivity(intent);
                Toast.makeText(OperaterActivity.this, "home", Toast.LENGTH_SHORT).show();
            }
        });

        device = (Button) findViewById(R.id.btn_device);
        device.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(OperaterActivity.this,"device",Toast.LENGTH_SHORT).show();
            }
        });

        feedback = (Button) findViewById(R.id.btn_feedback);
        feedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(OperaterActivity.this,"feedback",Toast.LENGTH_SHORT).show();
            }
        });

        manual = (Button) findViewById(R.id.btn_manual);
        manual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final EditText et = new EditText(OperaterActivity.this);
                new AlertDialog.Builder(OperaterActivity.this).setTitle("请输入密码")
                        .setIcon(android.R.drawable.sym_def_app_icon)
                        .setView(et)
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                //按下确定键后的事件
                                String passwd = et.getText().toString();
                                if(passwd.equals("0000")){
                                    Intent intent=new Intent(OperaterActivity.this,OperaterActivity.class);
                                    startActivity(intent);
                                }
                                else{
                                    Toast.makeText(getApplicationContext(),"密码错误",Toast.LENGTH_LONG).show();
                                }
                            }
                        }).setNegativeButton("取消",null).show();
            }
        });
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
                        Toast.makeText(OperaterActivity.this,"保存",Toast.LENGTH_SHORT).show();
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
