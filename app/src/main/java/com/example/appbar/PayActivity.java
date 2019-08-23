package com.example.appbar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.os.Bundle;
import android.text.InputType;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

public class PayActivity extends AppCompatActivity {
    private EditText mInputMoney;
    private EditText mInputInfo;
    private Button mBtnPay;
    private CheckBox mBankCardChkBx;
    private CheckBox mMobilePhoneChkBx;
    private CheckBox mCashAddressChkBx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay);
        initViews();
        Toolbar myToolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        mBtnPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(PayActivity.this, "Платёж на сумму " + mInputMoney.getText().toString() + " успешно осуществлён", Toast.LENGTH_LONG).show();
            }
        });
    }

    private void initViews() {
        mInputMoney = findViewById(R.id.txtInputMoney);
        mInputInfo = findViewById(R.id.txtPaymentInfo);
        mBtnPay = findViewById(R.id.btnPay);
        mBankCardChkBx = findViewById(R.id.chkBxBankCard);
        mMobilePhoneChkBx = findViewById(R.id.chkBxMobilePhone);
        mCashAddressChkBx = findViewById(R.id.chkBxCash);
        mBankCardChkBx.setOnCheckedChangeListener(checkedChangeListener);
        mMobilePhoneChkBx.setOnCheckedChangeListener(checkedChangeListener);
        mCashAddressChkBx.setOnCheckedChangeListener(checkedChangeListener);
    }

    private void resetCheckBoxes(){
        mBankCardChkBx.setChecked(false);
        mMobilePhoneChkBx.setChecked(false);
        mCashAddressChkBx.setChecked(false);
    }
    CompoundButton.OnCheckedChangeListener checkedChangeListener = new CompoundButton.OnCheckedChangeListener() {

        @Override
        public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
            if (b) {
                switch (compoundButton.getId()) {
                    case R.id.chkBxBankCard:
                        resetCheckBoxes();
                        mBankCardChkBx.setChecked(true);
                        mInputInfo.setInputType(InputType.TYPE_CLASS_NUMBER);
                        break;
                    case R.id.chkBxMobilePhone:
                        resetCheckBoxes();
                        mMobilePhoneChkBx.setChecked(true);
                        mInputInfo.setInputType(InputType.TYPE_CLASS_PHONE);
                        break;
                    case R.id.chkBxCash:
                        resetCheckBoxes();
                        mCashAddressChkBx.setChecked(true);
                        mInputInfo.setInputType(InputType.TYPE_CLASS_TEXT);
                        break;
                    default:
                }
            }
        }
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_open_notes) {
            Toast.makeText(PayActivity.this, "Открыть записную книжку", Toast.LENGTH_SHORT).show();
            Intent intentNotes = new Intent(PayActivity.this, NotesActivity.class);
            startActivity(intentNotes);
            return true;
        }

        if (id == R.id.action_open_tasks) {
            Toast.makeText(PayActivity.this, "Открыть задачи", Toast.LENGTH_SHORT).show();
            Intent intentTasks = new Intent(PayActivity.this, TasksActivity.class);
            startActivity(intentTasks);
        }

        if (id == R.id.action_open_subscribe) {
            Toast.makeText(PayActivity.this, "Открыть подписки", Toast.LENGTH_SHORT).show();
            Intent intentSubscribe = new Intent(PayActivity.this, SubscriptionActivity.class);
            startActivity(intentSubscribe);
        }

        if (id == R.id.action_open_pay) {
            Toast.makeText(PayActivity.this, "Открыть оплату", Toast.LENGTH_SHORT).show();
            Intent intentPay = new Intent(PayActivity.this, PayActivity.class);
            startActivity(intentPay);
        }

        return super.onOptionsItemSelected(item);
    }
}
