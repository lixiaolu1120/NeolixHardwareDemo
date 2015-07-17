package com.neolixhardwaredemo;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import static com.neolixhardwaredemo.Constants.BARCODE_SCANNER_ACTION_TRIGGER;
import static com.neolixhardwaredemo.Constants.BOXID;
import static com.neolixhardwaredemo.Constants.CLOSE_SCANNER_LED;
import static com.neolixhardwaredemo.Constants.DEFAULT_EMPTY;
import static com.neolixhardwaredemo.Constants.LOCK_CONTROLLER_OPEN;
import static com.neolixhardwaredemo.Constants.OPEN_SCANNER_LED;
import static com.neolixhardwaredemo.Constants.PRINTER_ACTION_HAS_PAPER;
import static com.neolixhardwaredemo.Constants.PRINTER_ACTION_TRIGGER;
import static com.neolixhardwaredemo.Constants.STATUS;
import static com.neolixhardwaredemo.Constants.STATUS_OFF;
import static com.neolixhardwaredemo.Constants.STATUS_ON;

public class DemoActivity extends Activity {

    private Button openScannerBt;
    private Button closeScannerBt;

    private Button scanBt;
    private Button openRFID;
    private Button closeRFID;
    private Button RFIDRead;
    private MyReceiver receiver;
    private Button initLockController;
    private Button openLock;
    private View closeLockController;
    private EditText doorNumberInput;
    private EditText setBoxAddressEt;
    private Button setBoxBt;
    private Button openCamera;
    private Button print;
    private Button cancelScanBt;
    private Button readStop;
    private Button openPrinter;
    private Button closePrinter;
    private Button paperState;
    private Button initIR;
    private Button closeIR;
    private Button detIR;
    private Button lockerStatus;
    private EditText boxStatusInput;
    private Button readIRCount;
    private Button dropBoxStatus;
    private Button openLED;
    private Button closeLED;
    private Button openAllLock;
    private Button lockerContent;
    private Button lockerContentWithOutResponse;
    private Button openScannerLED;
    private Button closeScannerLED;
    private Button openPrintLED;
    private Button closePrintLED;
    private Button openRFIDLED;
    private Button closeRFIDLED;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);

        initView();
        initListener();
        initReceiver();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(receiver);
    }

    private void initView() {
        openScannerBt = (Button) findViewById(R.id.open_scanner);
        closeScannerBt = (Button) findViewById(R.id.close_scanner);
        scanBt = (Button) findViewById(R.id.scan);
        cancelScanBt = (Button) findViewById(R.id.cancel_scan);

        openRFID = (Button) findViewById(R.id.open_RFID_reader);
        closeRFID = (Button) findViewById(R.id.close_RFID_reader);
        RFIDRead = (Button) findViewById(R.id.RFID_read);
        readStop = (Button) findViewById(R.id.RFID_read_stop);

        initLockController = (Button) findViewById(R.id.open_lock_control);
        openLock = (Button) findViewById(R.id.open_lock);
        closeLockController = findViewById(R.id.close_lock_control);
        doorNumberInput = (EditText) findViewById(R.id.door_number_input);
        setBoxAddressEt = (EditText) findViewById(R.id.set_box_address);
        setBoxBt = (Button) findViewById(R.id.set_lock);
        openAllLock = (Button) findViewById(R.id.open_all_lock);

        openCamera = (Button) findViewById(R.id.open_camera);

        print = (Button) findViewById(R.id.print);
        openPrinter = (Button) findViewById(R.id.open_printer);
        closePrinter = (Button) findViewById(R.id.close_printer);
        paperState = (Button) findViewById(R.id.paper_state);

        initIR = (Button) findViewById(R.id.init_IR);
        closeIR = (Button) findViewById(R.id.close_IR);
        detIR = (Button) findViewById(R.id.det_IR);
        readIRCount = (Button) findViewById(R.id.read_IR_count);
        dropBoxStatus = (Button) findViewById(R.id.get_drop_box_locker_status);

        lockerStatus = (Button) findViewById(R.id.get_locker_status);
        boxStatusInput = (EditText) findViewById(R.id.box_status_door_number_input);

        openLED = (Button) findViewById(R.id.open_led);
        closeLED = (Button) findViewById(R.id.close_led);

        openScannerLED = (Button) findViewById(R.id.open_scanner_led);
        closeScannerLED = (Button) findViewById(R.id.close_scanner_led);

        openPrintLED = (Button) findViewById(R.id.open_print_led);
        closePrintLED = (Button) findViewById(R.id.close_print_led);

        openRFIDLED = (Button) findViewById(R.id.open_RFID_led);
        closeRFIDLED = (Button) findViewById(R.id.close_RFID_led);

        lockerContent = (Button) findViewById(R.id.locker_content);
        lockerContentWithOutResponse = (Button) findViewById(R.id.locker_content_without_response);

    }

    private void initListener() {
        //SCANNER
        openScannerBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendTriggerBroadcast(BARCODE_SCANNER_ACTION_TRIGGER, STATUS_ON, STATUS);
            }
        });

        closeScannerBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendTriggerBroadcast(BARCODE_SCANNER_ACTION_TRIGGER, STATUS_OFF, STATUS);
            }
        });

        scanBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Constants.BARCODE_SCANNER_ACTION_SCAN);
                getApplicationContext().sendBroadcast(intent);
            }
        });

        cancelScanBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Constants.BARCODE_SCANNER_ACTION_CANCEL);
                getApplicationContext().sendBroadcast(intent);
            }
        });

        //RFID
        openRFID.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendTriggerBroadcast(Constants.RFID_READER_ACTION_TRIGGER, STATUS_ON, STATUS);
            }
        });

        closeRFID.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendTriggerBroadcast(Constants.RFID_READER_ACTION_TRIGGER, STATUS_OFF, STATUS);
            }
        });

        RFIDRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Constants.RFID_READER_ACTION_READ);
                getApplicationContext().sendBroadcast(intent);
            }
        });

        readStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Constants.RFID_READER_ACTION_CANCEL);
                getApplicationContext().sendBroadcast(intent);
            }
        });

        //LOCKER
        initLockController.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendTriggerBroadcast(Constants.lOCK_CONTROLLER_TRIGGER, STATUS_ON, STATUS);
            }
        });

        closeLockController.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendTriggerBroadcast(Constants.lOCK_CONTROLLER_TRIGGER, STATUS_OFF, STATUS);
            }
        });

        openLock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String doorNumber = doorNumberInput.getText().toString();
                sendLocalBroadcast(LOCK_CONTROLLER_OPEN, doorNumber, BOXID);
            }
        });

        openAllLock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

        setBoxBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String doorNumber = setBoxAddressEt.getText().toString();
                sendLocalBroadcast(Constants.LOCK_CONTROLLER_SET, doorNumber, BOXID);
            }
        });

        lockerStatus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String doorNumber = boxStatusInput.getText().toString();
                sendLocalBroadcast(Constants.LOCK_STATUS, doorNumber, BOXID);
            }
        });

        dropBoxStatus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendLocalBroadcast(Constants.LOCK_DROP_BOX_STATUS, "", BOXID);
            }
        });

        lockerContent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

        lockerContentWithOutResponse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DemoActivity.this, SecondLockerCotentActivity.class);
                startActivity(intent);
            }
        });

        //CAMERA
        openCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction("android.media.action.STILL_IMAGE_CAMERA");
                startActivity(intent);
            }
        });

        //PRINTER
        print.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent("android.intent.action.hal.printer.print");
                intent.putExtra("pstr ", "line(10,10,300,10,3)\n" + "line(10,10,300,10,3)\n" + "box(10,20,300,180,2)\n" + "text(12,25,24,0,Hello World 123!)\n" + "text(12,80,16,1,打印测试456)\n" + "barcode128(10,200,240,300,0123456789012)\n" + "text(20,305,16,0,0123456789012)\n" + "qrcode(10,340,180,智能储物柜SmartLocker)\n" + "text(20,525,16,10,智能储物柜SmartLocker)\n");
                sendBroadcast(intent);
            }
        });

        openPrinter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendTriggerBroadcast(PRINTER_ACTION_TRIGGER, STATUS_ON, STATUS);
            }
        });

        closePrinter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendTriggerBroadcast(PRINTER_ACTION_TRIGGER, STATUS_OFF, STATUS);
            }
        });

        paperState.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendTriggerBroadcast(PRINTER_ACTION_HAS_PAPER, DEFAULT_EMPTY, STATUS);
            }
        });

        //IR
        initIR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendTriggerBroadcast(Constants.IR_TRIGGER, STATUS_ON, STATUS);
            }
        });

        closeIR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendTriggerBroadcast(Constants.IR_TRIGGER, STATUS_OFF, STATUS);
            }
        });

        detIR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendLocalBroadcast(Constants.IR_ISFULL, "99", BOXID);
            }
        });

        readIRCount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendLocalBroadcast(Constants.IR_COUNT, "99", BOXID);
            }
        });

        //LED
        openLED.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendLocalBroadcast(Constants.OPEN_LED, "", "");
            }
        });

        closeLED.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendLocalBroadcast(Constants.CLOSE_LED, "", "");
            }
        });

        //scanner led
        openScannerLED.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendLocalBroadcast(OPEN_SCANNER_LED, "", "");
            }
        });

        closeScannerLED.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendLocalBroadcast(CLOSE_SCANNER_LED, "", "");
            }
        });

        //print led
        openPrintLED.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendLocalBroadcast(Constants.OPEN_PRINT_LED, "", "");
            }
        });

        closePrintLED.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendLocalBroadcast(Constants.CLOSE_PRINT_LED, "", "");
            }
        });

        openRFIDLED.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendLocalBroadcast(Constants.OPEN_RFID_LED, "", "");
            }
        });

        closeRFIDLED.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendLocalBroadcast(Constants.CLOSE_RFID_LED, "", "");
            }
        });
    }

    private void initReceiver() {
        receiver = new MyReceiver(this);
        IntentFilter filter = new IntentFilter();
        filter.addAction("android.intent.action.hal.barcodescanner.scandata");
        filter.addAction("android.intent.action.hal.lock.debug");
        filter.addAction("android.intent.action.hal.rfidreader.readdata");
        filter.addAction("android.intent.action.hal.printer.result.haspaper");
        filter.addAction("android.intent.action.hal.infrared.result.count");
        filter.addAction("android.intent.action.hal.infrared.result.isfull");
        filter.addAction("android.intent.action.hal.iocontroller.querydata");
        filter.addAction("android.intent.action.hal.dropinbox.querydata");
        registerReceiver(receiver, filter);
    }

    private void sendTriggerBroadcast(String action, int status, String extraName) {
        Intent intent = new Intent(action);
        intent.putExtra(extraName, status);
        getApplicationContext().sendBroadcast(intent);
    }

    private void sendLocalBroadcast(String action, String doorNumber, String extraName) {
        Intent intent = new Intent(action);
        intent.putExtra(extraName, doorNumber);
        getApplicationContext().sendBroadcast(intent);
    }

}