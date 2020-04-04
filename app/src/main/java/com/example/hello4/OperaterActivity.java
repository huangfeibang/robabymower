package com.example.hello4;

import android.app.AlertDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
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

import com.example.hello4.fragment.BottonFragment;

import java.util.Calendar;

public class OperaterActivity extends AppCompatActivity implements BottonFragment.OnFragmentInteractionListener {

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
        BottonFragment framents = new BottonFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.buttom,framents).commitAllowingStateLoss();
    }

    @Override
    public void onFragmentInteraction(Uri uri) {
        Toast.makeText(OperaterActivity.this,"this is："+uri,Toast.LENGTH_SHORT).show();
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
