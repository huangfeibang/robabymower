package com.example.hello4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class WorkingActivity extends AppCompatActivity {

    private Button mBtnmove_now;
    private Button auto_charge;
    private Button map;
    private Button booking;
    private Button manual;

    private Button home;
    private Button device;
    private Button feedback;
    private Button user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_working);
        mBtnmove_now = ((Button) findViewById(R.id.btn_move));
        mBtnmove_now.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(WorkingActivity.this,MoveActivity.class);
                startActivity(intent);

                //Toast.makeText(PendingActivity.this,"AutoCharge", Toast.LENGTH_SHORT).show();
            }
        });
        auto_charge = ((Button) findViewById(R.id.btn_auto));
        auto_charge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(WorkingActivity.this,MoveActivity.class);
                startActivity(intent);
                Toast.makeText(WorkingActivity.this,"AutoCharge", Toast.LENGTH_SHORT).show();
            }
        });
        map = ((Button) findViewById(R.id.btn_map));
        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(WorkingActivity.this,MoveActivity.class);
                startActivity(intent);
            }
        });
        booking = (Button) findViewById(R.id.btn_booking);
        booking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(WorkingActivity.this, "booking", Toast.LENGTH_SHORT).show();
            }
        });
        manual = (Button) findViewById(R.id.btn_manual);
        manual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(WorkingActivity.this, "manual", Toast.LENGTH_SHORT).show();
            }
        });

        home = (Button) findViewById(R.id.btn_home);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(WorkingActivity.this,WaitingActivity.class);
                startActivity(intent);
                Toast.makeText(WorkingActivity.this, "home", Toast.LENGTH_SHORT).show();
            }
        });
        device = (Button) findViewById(R.id.btn_device);
        device.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(WorkingActivity.this,"device",Toast.LENGTH_SHORT).show();
            }
        });
        feedback = (Button) findViewById(R.id.btn_feedback);
        feedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(WorkingActivity.this,"feedback",Toast.LENGTH_SHORT).show();
            }
        });
        user = (Button) findViewById(R.id.btn_user);
        user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(WorkingActivity.this, "user", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
