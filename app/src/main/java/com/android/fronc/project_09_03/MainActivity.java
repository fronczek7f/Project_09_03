package com.android.fronc.project_09_03;

import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private MyReceiver myReceiver = new MyReceiver();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        IntentFilter filter = new IntentFilter("com.android.fronc.project_09_01");
        filter.setPriority(3);
        registerReceiver(myReceiver, filter);
    }

    @Override
    public void onDestroy()
    {
        super.onDestroy();
        unregisterReceiver(myReceiver);
    }
}
