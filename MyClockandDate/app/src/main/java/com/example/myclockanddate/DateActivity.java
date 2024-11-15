package com.example.myclockanddate;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DateActivity extends AppCompatActivity {
    String history="",time="",text="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.date);
        DatePicker myDatePicker=(DatePicker) findViewById(R.id.datePicker);
        TextView dateText=(TextView)findViewById(R.id.dateText);
        TextView editText=(TextView)findViewById(R.id.editText);
        Button btnSaveDate=(Button)findViewById(R.id.btn_savedate);
        myDatePicker.setOnDateChangedListener(new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker datePicker, int i, int i1, int i2) {
                time=i+"年"+(i1+1)+"月"+i2+"日";
               }
        });
btnSaveDate.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        if(btnSaveDate.isClickable()) {
            text= editText.getText().toString();
            history=history+time+text+'\n';
            dateText.setText("您设定的日程为：\n" +history);

        }
    }
});

    }


}

