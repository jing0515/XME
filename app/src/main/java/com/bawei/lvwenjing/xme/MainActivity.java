package com.bawei.lvwenjing.xme;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.bawei.lvwenjing.xme.listview.ListviewActivity;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startActivity(new Intent(MainActivity.this,ListviewActivity.class));
    }
}
