package com.cookandroid.project6_1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Chronometer;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    Chronometer chrono;
    Button btnStart, btnEnd;
    RadioButton rdoCal, rdoTime;
    CalendarView calView;
    TimePicker tPicker;
    TextView tvYear, tvMonth, tvDay, tvHour, tvMinute;
    TextView tvT1, tvT2, tvT3, tvT4, tvT5, tvT6;
    int selectYear, selectMonth, selectDay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("시간 예약");

        btnStart = (Button) findViewById(R.id.btnStart);
        btnEnd = (Button) findViewById(R.id.btnEnd);

        chrono = (Chronometer) findViewById(R.id.chronometer1);

        rdoCal = (RadioButton) findViewById(R.id.rdoCal);
        rdoTime = (RadioButton) findViewById(R.id.rdoTime);

        tPicker = (TimePicker) findViewById(R.id.timePicker1);

        calView = (CalendarView) findViewById(R.id.calendarView1);

        tvYear = (TextView) findViewById(R.id.tvYear);
        tvMonth = (TextView) findViewById(R.id.tvMonth);
        tvDay = (TextView) findViewById(R.id.tvDay);
        tvHour = (TextView) findViewById(R.id.tvHour);
        tvMinute = (TextView) findViewById(R.id.tvMinute);

        tvT1 = (TextView) findViewById(R.id.tvT1); //년
        tvT2 = (TextView) findViewById(R.id.tvT2); //월
        tvT3 = (TextView) findViewById(R.id.tvT3); //일
        tvT4 = (TextView) findViewById(R.id.tvT4); //시
        tvT5 = (TextView) findViewById(R.id.tvT5); //분
        tvT6 = (TextView) findViewById(R.id.tvT6); //예약됨

        //타임피커, 캘린더 뷰 숨김
        tPicker.setVisibility(View.INVISIBLE);
        calView.setVisibility(View.INVISIBLE);

        //출력 텍스트 숨김
        tvYear.setVisibility(View.INVISIBLE);
        tvMonth.setVisibility(View.INVISIBLE);
        tvDay.setVisibility(View.INVISIBLE);
        tvHour.setVisibility(View.INVISIBLE);
        tvMinute.setVisibility(View.INVISIBLE);

        tvT1.setVisibility(View.INVISIBLE);
        tvT2.setVisibility(View.INVISIBLE);
        tvT3.setVisibility(View.INVISIBLE);
        tvT4.setVisibility(View.INVISIBLE);
        tvT5.setVisibility(View.INVISIBLE);
        tvT6.setVisibility(View.INVISIBLE);


        rdoCal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tPicker.setVisibility(View.INVISIBLE);
                calView.setVisibility(View.VISIBLE);
            }
        });

        rdoTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tPicker.setVisibility(View.VISIBLE);
                calView.setVisibility(View.INVISIBLE);
            }
        });

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chrono.setBase(SystemClock.elapsedRealtime());
                chrono.start();
                chrono.setTextColor(Color.RED);

                //출력 텍스트 숨김
                tvYear.setVisibility(View.INVISIBLE);
                tvMonth.setVisibility(View.INVISIBLE);
                tvDay.setVisibility(View.INVISIBLE);
                tvHour.setVisibility(View.INVISIBLE);
                tvMinute.setVisibility(View.INVISIBLE);

                tvT1.setVisibility(View.INVISIBLE);
                tvT2.setVisibility(View.INVISIBLE);
                tvT3.setVisibility(View.INVISIBLE);
                tvT4.setVisibility(View.INVISIBLE);
                tvT5.setVisibility(View.INVISIBLE);
                tvT6.setVisibility(View.INVISIBLE);
            }
        });


        btnEnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chrono.stop();
                chrono.setTextColor(Color.BLUE);

                //저장된 값 출력
                tvYear.setText(Integer.toString(selectYear)); //년
                tvMonth.setText(Integer.toString(selectMonth)); //월
                tvDay.setText(Integer.toString(selectDay)); //일

                tvHour.setText(Integer.toString(tPicker.getCurrentHour()));
                tvMinute.setText(Integer.toString(tPicker.getCurrentMinute()));

                //숨긴 텍스트 나타남.
                tvYear.setVisibility(View.VISIBLE);
                tvMonth.setVisibility(View.VISIBLE);
                tvDay.setVisibility(View.VISIBLE);
                tvHour.setVisibility(View.VISIBLE);
                tvMinute.setVisibility(View.VISIBLE);

                tvT1.setVisibility(View.VISIBLE);
                tvT2.setVisibility(View.VISIBLE);
                tvT3.setVisibility(View.VISIBLE);
                tvT4.setVisibility(View.VISIBLE);
                tvT5.setVisibility(View.VISIBLE);
                tvT6.setVisibility(View.VISIBLE);

            }
        });

        calView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                selectYear = year;
                selectMonth = month + 1;
                selectDay = dayOfMonth;
            }
        });

    }
}