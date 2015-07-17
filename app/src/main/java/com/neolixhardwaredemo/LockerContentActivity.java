package com.neolixhardwaredemo;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import static com.neolixhardwaredemo.Constants.BOXID;
import static com.neolixhardwaredemo.Constants.LOCK_CONTROLLER_OPEN;
import static com.neolixhardwaredemo.Constants.LOCK_STATUS;

public class LockerContentActivity extends Activity implements Button.OnClickListener {

    private Button lock1;
    private Button lock2;
    private Button lock3;
    private Button lock4;
    private Button lock5;
    private Button lock6;
    private Button lock7;
    private Button lock8;
    private Button lock9;
    private Button lock10;
    private Button lock11;
    private Button lock12;
    private Button lock13;
    private Button lock14;
    private Button lock15;
    private Button lock16;
    private Button lock17;
    private Button lock18;
    private Button lock19;
    private Button lock21;
    private Button lock20;
    private Button lock22;
    private Button lock23;
    private Button lock24;
    private Button lock25;
    private Button lock26;
    private Button lock27;
    private Button lock28;
    private Button lock29;
    private Button lock30;
    private Button lock31;
    private Button lock32;
    private Button lock33;
    private Button lock34;
    private Button lock35;
    private Button lock36;
    private Button lock37;
    private Button lock38;
    private Button lock39;
    private Button lock40;
    private Button lock41;
    private Button lock42;
    private Button lock43;
    private Button lock44;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_lock);
        initReceiver();

        initView();

        initListener();
    }

    private void initView() {
        lock1 = (Button) findViewById(R.id.locker_1);
        lock2 = (Button) findViewById(R.id.locker_2);
        lock3 = (Button) findViewById(R.id.locker_3);
        lock4 = (Button) findViewById(R.id.locker_4);
        lock5 = (Button) findViewById(R.id.locker_5);
        lock6 = (Button) findViewById(R.id.locker_6);
        lock7 = (Button) findViewById(R.id.locker_7);
        lock8 = (Button) findViewById(R.id.locker_8);
        lock9 = (Button) findViewById(R.id.locker_9);
        lock10 = (Button) findViewById(R.id.locker_10);
        lock11 = (Button) findViewById(R.id.locker_11);
        lock12 = (Button) findViewById(R.id.locker_12);
        lock13 = (Button) findViewById(R.id.locker_13);
        lock14 = (Button) findViewById(R.id.locker_14);
        lock15 = (Button) findViewById(R.id.locker_15);
        lock16 = (Button) findViewById(R.id.locker_16);
        lock17 = (Button) findViewById(R.id.locker_17);
        lock18 = (Button) findViewById(R.id.locker_18);
        lock19 = (Button) findViewById(R.id.locker_19);
        lock20 = (Button) findViewById(R.id.locker_20);
        lock21 = (Button) findViewById(R.id.locker_21);
        lock22 = (Button) findViewById(R.id.locker_22);
        lock23 = (Button) findViewById(R.id.locker_23);
        lock24 = (Button) findViewById(R.id.locker_24);
        lock25 = (Button) findViewById(R.id.locker_25);
        lock26 = (Button) findViewById(R.id.locker_26);
        lock27 = (Button) findViewById(R.id.locker_27);
        lock28 = (Button) findViewById(R.id.locker_28);
        lock29 = (Button) findViewById(R.id.locker_29);
        lock30 = (Button) findViewById(R.id.locker_30);
        lock31 = (Button) findViewById(R.id.locker_31);
        lock32 = (Button) findViewById(R.id.locker_32);
        lock33 = (Button) findViewById(R.id.locker_33);
        lock34 = (Button) findViewById(R.id.locker_34);
        lock35 = (Button) findViewById(R.id.locker_35);
        lock36 = (Button) findViewById(R.id.locker_36);
        lock37 = (Button) findViewById(R.id.locker_37);
        lock38 = (Button) findViewById(R.id.locker_38);
        lock39 = (Button) findViewById(R.id.locker_39);
        lock40 = (Button) findViewById(R.id.locker_40);
        lock41 = (Button) findViewById(R.id.locker_41);
        lock42 = (Button) findViewById(R.id.locker_42);
        lock43 = (Button) findViewById(R.id.locker_43);
        lock44 = (Button) findViewById(R.id.locker_44);
    }

    private void initListener() {
        lock1.setOnClickListener(this);
        lock2.setOnClickListener(this);
        lock3.setOnClickListener(this);
        lock4.setOnClickListener(this);
        lock5.setOnClickListener(this);
        lock6.setOnClickListener(this);
        lock7.setOnClickListener(this);
        lock8.setOnClickListener(this);
        lock9.setOnClickListener(this);
        lock10.setOnClickListener(this);
        lock11.setOnClickListener(this);
        lock12.setOnClickListener(this);
        lock13.setOnClickListener(this);
        lock14.setOnClickListener(this);
        lock15.setOnClickListener(this);
        lock16.setOnClickListener(this);
        lock17.setOnClickListener(this);
        lock18.setOnClickListener(this);
        lock19.setOnClickListener(this);
        lock20.setOnClickListener(this);
        lock21.setOnClickListener(this);
        lock22.setOnClickListener(this);
        lock23.setOnClickListener(this);
        lock24.setOnClickListener(this);
        lock25.setOnClickListener(this);
        lock26.setOnClickListener(this);
        lock27.setOnClickListener(this);
        lock28.setOnClickListener(this);
        lock29.setOnClickListener(this);
        lock30.setOnClickListener(this);
        lock31.setOnClickListener(this);
        lock32.setOnClickListener(this);
        lock33.setOnClickListener(this);
        lock34.setOnClickListener(this);
        lock35.setOnClickListener(this);
        lock36.setOnClickListener(this);
        lock37.setOnClickListener(this);
        lock38.setOnClickListener(this);
        lock39.setOnClickListener(this);
        lock40.setOnClickListener(this);
        lock41.setOnClickListener(this);
        lock42.setOnClickListener(this);
        lock43.setOnClickListener(this);
        lock44.setOnClickListener(this);
    }

    private void initReceiver() {
        IntentFilter filter = new IntentFilter();
        filter.addAction("android.intent.action.hal.barcodescanner.scandata");
        filter.addAction("android.intent.action.hal.lock.debug");
        filter.addAction("android.intent.action.hal.rfidreader.readdata");
        filter.addAction("android.intent.action.hal.printer.result.haspaper");
        filter.addAction("android.intent.action.hal.infrared.result.count");
        filter.addAction("android.intent.action.hal.infrared.result.isfull");
        filter.addAction("android.intent.action.hal.iocontroller.querydata");
        filter.addAction("android.intent.action.hal.dropinbox.querydata");
        BroadcastReceiver receiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                String action = intent.getAction();
                if (action.equals("android.intent.action.hal.iocontroller.querydata")) {
                    String boxid = intent.getStringExtra("boxid");
                    boolean data = intent.getBooleanExtra("isopened", false);
                    String isOpened = data ? " open" : " close";
                    ResMatcher matcher = new ResMatcher();
                    int match = matcher.match(boxid);
                    Button button = (Button) findViewById(match);
                    button.setText(boxid + isOpened);
                }
            }
        };
        registerReceiver(receiver, filter);
    }

    private void sendLocalBroadcast(String action, String doorNumber, String extraName) {
        Intent intent = new Intent(action);
        intent.putExtra(extraName, doorNumber);
        getApplicationContext().sendBroadcast(intent);
    }

    @Override
    public void onClick(View v) {
        Log.i("", "onClicked!");
        Button button = (Button) v;
        try {
            Thread.sleep(1100);
            sendLocalBroadcast(LOCK_CONTROLLER_OPEN, "A" + button.getText().toString(), BOXID);
            Thread.sleep(1000);
            sendLocalBroadcast(LOCK_STATUS, "A" + button.getText().toString(), BOXID);
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}