package com.bawei.lvwenjing.xme.photoview;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;

import com.bawei.lvwenjing.xme.R;

public class PhotoViewActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_view);
        int[] path = new int[]{R.drawable.f, R.drawable.pp, R.drawable.q, R.drawable.ss};
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        PhotoAdapter adapter = new PhotoAdapter(path, PhotoViewActivity.this);
        viewPager.setAdapter(adapter);

    }
}
