package com.example.appbar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar myToolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
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
            Toast.makeText(MainActivity.this, "Открыть записную книжку", Toast.LENGTH_SHORT).show();
            Intent intentNotes = new Intent(MainActivity.this, NotesActivity.class);
            startActivity(intentNotes);
            return true;
        }

        if (id == R.id.action_open_tasks) {
            Toast.makeText(MainActivity.this, "Открыть задачи", Toast.LENGTH_SHORT).show();
            Intent intentTasks = new Intent(MainActivity.this, TasksActivity.class);
            startActivity(intentTasks);
        }

        if (id == R.id.action_open_subscribe) {
            Toast.makeText(MainActivity.this, "Открыть подписки", Toast.LENGTH_SHORT).show();
            Intent intentSubscribe = new Intent(MainActivity.this, SubscriptionActivity.class);
            startActivity(intentSubscribe);
        }

        if (id == R.id.action_open_pay) {
            Toast.makeText(MainActivity.this, "Открыть оплату", Toast.LENGTH_SHORT).show();
            Intent intentPay = new Intent(MainActivity.this, PayActivity.class);
            startActivity(intentPay);
        }

        return super.onOptionsItemSelected(item);
    }
}
