package com.love.flower;

import android.app.Activity;
import android.os.Bundle;


public class MainActivity extends BaseCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //
        setContentView(R.layout.activity_main);

    }

    @Override
    protected int getLayoutId() {
        return 0;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {

    }
}
