package com.example.hello4.fragment;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.hello4.MoveActivity;
import com.example.hello4.OperaterActivity;
import com.example.hello4.R;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link BottonFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link BottonFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BottonFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

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


    private OnFragmentInteractionListener mListener;

    public BottonFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BottonFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static BottonFragment newInstance(String param1, String param2) {
        BottonFragment fragment = new BottonFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
        //mBtnMoveNow.findViewById(R.id.btn_move);
        /*
        mBtnAutoCharge =  findViewById(R.id.btn_auto);
        mBtnMap =  findViewById(R.id.btn_map);
        mBtnBooking = findViewById(R.id.btn_booking);
        mBtnManual =  findViewById(R.id.btn_manual);
        mBtnHome =  findViewById(R.id.btn_home);
        mBtnDevice = findViewById(R.id.btn_device);
        mBtnFeedback =  findViewById(R.id.btn_feedback);
        mBtnUser =  findViewById(R.id.btn_user);
        */
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_button, container, false);
        initSound();
        mBtnMoveNow = view.findViewById(R.id.btn_move);
        mBtnMoveNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OnMove();
            }
        });

        mBtnAutoCharge =  view.findViewById(R.id.btn_auto);
        mBtnAutoCharge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OnAuto();
            }

        });
        mBtnMap = view.findViewById(R.id.btn_map);
        mBtnMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OnMap();
            }
        });
        mBtnBooking = view.findViewById(R.id.btn_booking);
        mBtnBooking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OnBooking();
            }
        });
        mBtnManual = view.findViewById(R.id.btn_manual);
        mBtnManual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OnManual();
            }
        });
        /*
        mBtnMap =  findViewById(R.id.btn_map);
        mBtnBooking = findViewById(R.id.btn_booking);
        mBtnManual =  findViewById(R.id.btn_manual);
        mBtnHome =  findViewById(R.id.btn_home);
        mBtnDevice = findViewById(R.id.btn_device);
        mBtnFeedback =  findViewById(R.id.btn_feedback);
        mBtnUser =  findViewById(R.id.btn_user);
        */
        return view;
    }

    private void iniButton(View view){

    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }


    private void OnMove(){
        playSound();
        Toast.makeText(getActivity(),"Moving", Toast.LENGTH_SHORT).show();
    }
    private void OnAuto(){
        playSound();
        Toast.makeText(getActivity(),"autocharge",Toast.LENGTH_SHORT).show();
    }
    private void OnMap(){
        playSound();
        Intent intent=new Intent(getActivity(), MoveActivity.class);
        startActivity(intent);
        Toast.makeText(getActivity(), "Mapping", Toast.LENGTH_SHORT).show();
    }
    private void OnBooking(){
        Calendar calendar = Calendar.getInstance();
        int hourOfDay = calendar.get(Calendar.HOUR);
        int minute = calendar.get(Calendar.MINUTE);
        playSound();
        TimePickerDialog pikerDialog = new TimePickerDialog(getActivity(), new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                final String[] weekday = new String[]{"Mon","Tues","Wed","Thur","Fri","Sat","Sun"};
                boolean[] begin = new boolean[]{false,false,false,false,false,false,false};
                final List<String> choose = new ArrayList<>();
                androidx.appcompat.app.AlertDialog.Builder builder = new androidx.appcompat.app.AlertDialog.Builder(getContext());
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
                        Toast.makeText(getActivity(), "You chooce"+choose.toString()+"to start move", Toast.LENGTH_SHORT).show();
                    }
                }).show();
                Toast.makeText(getActivity(), "Will start at "+hourOfDay + ":" + minute, Toast.LENGTH_SHORT).show();
            }
        }, hourOfDay, minute, true);
        pikerDialog.show();
    }
    private void OnManual(){
        playSound();
        final EditText et = new EditText(getActivity());
        new AlertDialog.Builder(getActivity()).setTitle("Password")
                .setIcon(android.R.drawable.sym_def_app_icon)
                .setView(et)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String passwd = et.getText().toString();
                        if(passwd.equals("0000")){
                            Intent intent=new Intent(getActivity(), OperaterActivity.class);
                            startActivity(intent);
                        }
                        else{
                            Toast.makeText(getContext(),"Password error",Toast.LENGTH_LONG).show();
                        }
                    }
                })
                .setNegativeButton("cancel",null)
                .show();
    }

    private void PlayMusic(int MusicId) {
        music = MediaPlayer.create(getContext(), MusicId);
        music.start();
    }
    @SuppressLint("NewApi")
    private void initSound() {
        soundPool = new SoundPool.Builder().build();
        soundID = soundPool.load(getContext(), R.raw.jianpan, 1);
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
