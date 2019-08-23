package com.example.appbar;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.widget.Toolbar;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class NotesActivity extends AppCompatActivity {

    private EditText mInputNote;
    private Button mBtnSaveNote;
    private SharedPreferences myNoteSharedPref;
    private static String NOTE_TEXT = "note_text";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);
        initViews();
        getDateFromSharedPref();
    }

    private void initViews() {
        Toolbar myToolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        mInputNote = findViewById(R.id.inputNote);
        mBtnSaveNote = findViewById(R.id.btnSaveNote);
        myNoteSharedPref = getSharedPreferences("MyNote", MODE_PRIVATE);

        mBtnSaveNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor myEditor = myNoteSharedPref.edit();
                String noteTxt = mInputNote.getText().toString();
                myEditor.putString(NOTE_TEXT, noteTxt);
                myEditor.apply();
                Toast.makeText(NotesActivity.this, "Заметка добавлена!", Toast.LENGTH_LONG).show();
            }
        });
    }

    private void getDateFromSharedPref() {
        String noteTxt = myNoteSharedPref.getString(NOTE_TEXT, "");
        mInputNote.setText(noteTxt);
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
            Toast.makeText(NotesActivity.this, "Открыть записную книжку", Toast.LENGTH_SHORT).show();
            Intent intentNotes = new Intent(NotesActivity.this, NotesActivity.class);
            startActivity(intentNotes);
            return true;
        }

        if (id == R.id.action_open_tasks) {
            Toast.makeText(NotesActivity.this, "Открыть задачи", Toast.LENGTH_SHORT).show();
            Intent intentTasks = new Intent(NotesActivity.this, TasksActivity.class);
            startActivity(intentTasks);
        }

        if (id == R.id.action_open_subscribe) {
            Toast.makeText(NotesActivity.this, "Открыть подписки", Toast.LENGTH_SHORT).show();
            Intent intentSubscribe = new Intent(NotesActivity.this, SubscriptionActivity.class);
            startActivity(intentSubscribe);
        }

        if (id == R.id.action_open_pay) {
            Toast.makeText(NotesActivity.this, "Открыть оплату", Toast.LENGTH_SHORT).show();
            Intent intentPay = new Intent(NotesActivity.this, PayActivity.class);
            startActivity(intentPay);
        }

        return super.onOptionsItemSelected(item);
    }
}
