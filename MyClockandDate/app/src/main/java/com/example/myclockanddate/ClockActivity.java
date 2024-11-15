package com.example.myclockanddate;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.appcompat.app.AppCompatActivity;

public class ClockActivity extends AppCompatActivity {
    String clock="",freq="",time="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.clock);
        TimePicker myTimePicker=(TimePicker) findViewById(R.id.timePicker);
        Button btnSaveClock=(Button) findViewById(R.id.btn_saveclock);
        TextView clockText=(TextView) findViewById(R.id.clockText);
        RadioButton every=(RadioButton)findViewById(R.id.everyday);//通过id找到checkbox
        RadioButton work=(RadioButton)findViewById(R.id.workday);//通过id找到checkbox
        RadioButton once=(RadioButton)findViewById(R.id.once);//通过id找到checkbox
        once.setChecked(true);
        myTimePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker timePicker, int i, int i1) {
                if (i == 0) {
                    time = "0" + i + ":";
                } else {
                    time = i + ":";
                }
                if (i1 == 0) {
                    time = time + "0" + i1;
                } else {
                    time = time + i1;
                }
            }
        });
        btnSaveClock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(every.isChecked()){
                    freq = " 每日重复 ";
                }
                if(work.isChecked()){
                    freq = " 工作日重复 ";
                }
                if(once.isChecked()){
                    freq = " 仅一次 ";
                }
                if(!time.equals("") && !freq.equals("")){
                    clock = clock + time + freq +'\n';
                    clockText.setText("您设定的闹钟为：\n"+clock);
                }
            }
        });
     }
}
