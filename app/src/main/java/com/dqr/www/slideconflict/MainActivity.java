package com.dqr.www.slideconflict;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private ViewPager mViewPager1;
    private ViewPager mViewPager2;
    private ViewPager mViewPager3;
    private ViewPager mViewPager4;
    private ViewPager mViewPager5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mViewPager1= (ViewPager) findViewById(R.id.vp_pager1);
        mViewPager2= (ViewPager) findViewById(R.id.vp_pager2);
        mViewPager3= (ViewPager) findViewById(R.id.vp_pager3);
        mViewPager4= (ViewPager) findViewById(R.id.vp_pager4);
        mViewPager5= (ViewPager) findViewById(R.id.vp_pager5);

        ViewPageAdapter adapter=new ViewPageAdapter();

        mViewPager1.setAdapter(adapter);
        mViewPager2.setAdapter(adapter);
        mViewPager3.setAdapter(adapter);
        mViewPager4.setAdapter(adapter);
        mViewPager5.setAdapter(adapter);


        mViewPager1.setOnTouchListener(new TouchListener(mViewPager1));
        mViewPager2.setOnTouchListener(new TouchListener(mViewPager2));
        mViewPager3.setOnTouchListener(new TouchListener(mViewPager3));
        mViewPager4.setOnTouchListener(new TouchListener(mViewPager4));
        mViewPager5.setOnTouchListener(new TouchListener(mViewPager5));


    }
}
