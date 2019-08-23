package com.example.appbar;

import android.support.v7.widget.Toolbar;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.Toast;

import java.util.GregorianCalendar;

public class TasksActivity extends AppCompatActivity {
    private EditText txtTaskName;
    private Button mChooseStartDate;
    private Button mChooseEndDate;
    private CalendarView mStartDateCalendar;
    private CalendarView mEndDateCalendar;
    private Button mBtnAdd;
    private long mStartDate;
    private String mStartDateTxt;
    private long mEndDate;
    private String mEndDateTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tasks);
        initViews();
    }

    private void initViews() {
        Toolbar myToolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        txtTaskName = findViewById(R.id.txtTaskName);
        mChooseStartDate = findViewById(R.id.btnStartDate);
        mChooseEndDate = findViewById(R.id.btnEndDate);
        mStartDateCalendar = findViewById(R.id.cVstartDate);
        mEndDateCalendar = findViewById(R.id.cVendDate);
        mBtnAdd = findViewById(R.id.btnAdd);
        final Intent intent = new Intent(TasksActivity.this, TasksActivity.class);
        mStartDateCalendar.setVisibility(View.GONE);
        mEndDateCalendar.setVisibility(View.GONE);

        mChooseStartDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mStartDateCalendar.setVisibility(View.VISIBLE);
                mEndDateCalendar.setVisibility(View.GONE);
            }
        });

        mChooseEndDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mEndDateCalendar.setVisibility(View.VISIBLE);
                mStartDateCalendar.setVisibility(View.GONE);
            }
        });

        mStartDateCalendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int i, int i1, int i2) {
                mStartDateTxt = i+"-"+i1+"-"+i2;
                mChooseStartDate.setText("Дата начала задачи" + " " + mStartDateTxt);
                GregorianCalendar gregorianCalendar = new GregorianCalendar();
                gregorianCalendar.set(i, i1, i2);
                mStartDate = gregorianCalendar.getTimeInMillis();
                calendarView.setVisibility(View.GONE);
            }
        });

        mEndDateCalendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int i, int i1, int i2) {
                mEndDateTxt = i+"-"+i1+"-"+i2;
                mChooseEndDate.setText("Дата окончания задачи" + " " + mEndDateTxt);
                GregorianCalendar gregorianCalendar = new GregorianCalendar();
                gregorianCalendar.set(i, i1, i2);
                mEndDate = gregorianCalendar.getTimeInMillis();
                calendarView.setVisibility(View.GONE);
            }
        });

        mBtnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mStartDate > mEndDate){
                    Toast.makeText(TasksActivity.this, "Ошибка", Toast.LENGTH_LONG).show();
                    mChooseStartDate.setText("Дата начала задачи");
                    mChooseEndDate.setText("Дата завершения задачи");
                } else {
                    startActivity(intent);
                    Toast.makeText(TasksActivity.this, "Задача " + "'"+ txtTaskName.getText().toString() + "' успешно добавлена!" + " Старт: " + mStartDateTxt + " Завершение: " + mEndDateTxt, Toast.LENGTH_LONG).show();
                }
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_open_notes) {
            Toast.makeText(TasksActivity.this, "Открыть записную книжку", Toast.LENGTH_SHORT).show();
            Intent intentNotes = new Intent(TasksActivity.this, NotesActivity.class);
            startActivity(intentNotes);
            return true;
        }

        if (id == R.id.action_open_tasks) {
            Toast.makeText(TasksActivity.this, "Открыть задачи", Toast.LENGTH_SHORT).show();
            Intent intentTasks = new Intent(TasksActivity.this, TasksActivity.class);
            startActivity(intentTasks);
        }

        if (id == R.id.action_open_subscribe) {
            Toast.makeText(TasksActivity.this, "Открыть подписки", Toast.LENGTH_SHORT).show();
            Intent intentSubscribe = new Intent(TasksActivity.this, SubscriptionActivity.class);
            startActivity(intentSubscribe);
        }

        if (id == R.id.action_open_pay) {
            Toast.makeText(TasksActivity.this, "Открыть оплату", Toast.LENGTH_SHORT).show();
            Intent intentPay = new Intent(TasksActivity.this, PayActivity.class);
            startActivity(intentPay);
        }

        return super.onOptionsItemSelected(item);
    }
}
