package com.neolixhardwaredemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import java.util.Arrays;

import static android.widget.Toast.LENGTH_LONG;
import static android.widget.Toast.LENGTH_SHORT;
import static com.neolixhardwaredemo.Constants.HASPAPER;
import static com.neolixhardwaredemo.Constants.LOCAL_TAG;
import static com.neolixhardwaredemo.Constants.RFID_RECEIVE;

public class MyReceiver extends BroadcastReceiver {

    private Context context;

    public MyReceiver(Context context) {
        this.context = context;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();

        if (action.equals(Constants.SCANNER_RECEIVE)) {
            String scandata = intent.getStringExtra(Constants.SCANDATA);
            Log.i(LOCAL_TAG, "scandata:" + scandata);
            Toast.makeText(this.context.getApplicationContext(), scandata, LENGTH_SHORT).show();
        }

        if (action.equals(RFID_RECEIVE)) {
            String readdata = intent.getStringExtra(Constants.READDATA);
            Log.i(LOCAL_TAG, "scandata:" + readdata);
            Toast.makeText(this.context.getApplicationContext(), readdata, LENGTH_SHORT).show();
        }

        if (action.equals(Constants.LOCK_DEBUG_RECEIVE)) {
            String data = intent.getStringExtra(Constants.LOCK_DEBUG);
            byte[] bytes = data.getBytes();
            Log.i(LOCAL_TAG, "lock_debug_receive:" + Arrays.toString(bytes));
        }

        if (action.equals(Constants.PAPER_STATUS_RECEIVE)) {
            boolean hasPaper = intent.getBooleanExtra(HASPAPER, false);
            String toastContent = hasPaper ? "打印机有纸" : "打印机没纸";
            Toast.makeText(this.context, toastContent, LENGTH_SHORT).show();
        }

        if (action.equals("android.intent.action.hal.infrared.result.isfull")) {
            boolean data = intent.getBooleanExtra("isfull", false);
            String text = data ? "红外没挡住" : "红外挡住了";
            Toast.makeText(this.context, text, LENGTH_LONG).show();
        }

        if (action.equals("android.intent.action.hal.infrared.result.count")) {
            int count = intent.getExtras().getInt("count");
            Toast.makeText(this.context, "红外次数：" + count, LENGTH_LONG).show();
        }

        if (action.equals("android.intent.action.hal.iocontroller.querydata")) {
            boolean data = intent.getBooleanExtra("isopened", false);
            String boxid = intent.getStringExtra("boxid");
            String text = data ? "  锁状态：打开" : "锁状态 ：关闭";
            Toast.makeText(this.context, "锁号： " + boxid + text, LENGTH_LONG).show();
        }

        if (action.equals("android.intent.action.hal.dropinbox.querydata")) {
            boolean data = intent.getBooleanExtra("isopened", false);
            String text = data ? "锁状态：关闭" : "锁状态 ：打开";
            Toast.makeText(this.context, text, LENGTH_LONG).show();
        }
    }

}