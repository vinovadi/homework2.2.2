package com.example.appbar;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

public class SubscriptionActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subscription);
        Toolbar myToolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        final Intent intent = new Intent(SubscriptionActivity.this, SubscriptionActivity.class);
        final TextView userNameInput = findViewById(R.id.userNameInput);
        final TextView userEmailInput = findViewById(R.id.userEmailInput);


        final TextView resultText = findViewById(R.id.txtResult);
        Button btnOK = findViewById(R.id.btnOK);
        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String userName = userNameInput.getText().toString();
                final String userEmail = userEmailInput.getText().toString();
                resultText.setText("Подписка на рассылку успешно оформлена для пользователя " + userName + " на электронный адрес " + userEmail);
            }
        });

        Button btnClear = findViewById(R.id.btnClear);
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent);
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
            Toast.makeText(SubscriptionActivity.this, "Открыть записную книжку", Toast.LENGTH_SHORT).show();
            Intent intentNotes = new Intent(SubscriptionActivity.this, NotesActivity.class);
            startActivity(intentNotes);
            return true;
        }

        if (id == R.id.action_open_tasks) {
            Toast.makeText(SubscriptionActivity.this, "Открыть задачи", Toast.LENGTH_SHORT).show();
            Intent intentTasks = new Intent(SubscriptionActivity.this, TasksActivity.class);
            startActivity(intentTasks);
        }

        if (id == R.id.action_open_subscribe) {
            Toast.makeText(SubscriptionActivity.this, "Открыть подписки", Toast.LENGTH_SHORT).show();
            Intent intentSubscribe = new Intent(SubscriptionActivity.this, SubscriptionActivity.class);
            startActivity(intentSubscribe);
        }

        if (id == R.id.action_open_pay) {
            Toast.makeText(SubscriptionActivity.this, "Открыть оплату", Toast.LENGTH_SHORT).show();
            Intent intentPay = new Intent(SubscriptionActivity.this, PayActivity.class);
            startActivity(intentPay);
        }

        return super.onOptionsItemSelected(item);
    }
}
