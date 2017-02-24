package com.dqr.www.slideconflict;

import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {



    private ViewPager mViewPager1;
    private ViewPager mViewPager2;
    private ViewPager mViewPager3;
    private ViewPager mViewPager4;
    private ViewPager mViewPager5;

    @RequiresApi(api = Build.VERSION_CODES.M)
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


       final LinearLayout llt= (LinearLayout) findViewById(R.id.llt_content);
        final HorizontalScrollViewSubClass hls= (HorizontalScrollViewSubClass) findViewById(R.id.hls_content);
        findViewById(R.id.click).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Rect localVisibleRect = new Rect();//自身可见坐标区域,可见左上角为0,0
                mViewPager1.getLocalVisibleRect(localVisibleRect);

                Rect globalVisibleRect = new Rect();//View相对于屏幕绝对坐标 可见区域
                mViewPager1.getGlobalVisibleRect(globalVisibleRect);

                int [] locationOnScreen=new int[2];//View相对于屏幕的左上角坐标
                mViewPager1.getLocationOnScreen(locationOnScreen);

                int[] locationInWindow = new int[2];//如果为普通Activity则Y坐标为View左上角到屏幕顶部（此时Window与屏幕一样大）；如果为对话框式的Activity则Y坐标为当前Dialog模式Activity的标题栏顶部到View左上角的距离。
                mViewPager1.getLocationInWindow(locationInWindow);

              /*  Log.d("location", "localVisibleRect: left:"+localVisibleRect.left
                        +" top: "+localVisibleRect.top
                        +" right:"+localVisibleRect.right
                        +" bottom:"+localVisibleRect.bottom);

                Log.d("location", " globalVisibleRect: left:"+globalVisibleRect.left
                        +" top: "+globalVisibleRect.top
                        +" right:"+globalVisibleRect.right
                        +" bottom:"+globalVisibleRect.bottom);

              Log.d("location", " locationOnScreen: 左上角X:"+locationOnScreen[0]
                        +" : 左上角y: "+locationOnScreen[1]);

                Log.d("location", " locationInWindow: 左上角X:"+locationInWindow[0]
                        +" : 左上角y: "+locationInWindow[1]);*/

                /*  Log.d("location", " 相对于Parent left:"+mViewPager1.getLeft()
                        +" top: "+mViewPager1.getTop()
                        +" right:"+mViewPager1.getRight()
                        +" bottom:"+mViewPager1.getBottom());

                Log.d("location", " 相对于初始位置偏移量: ScrollX:"+mViewPager1.getScrollX()
                        +"ScrollY: "+mViewPager1.getScrollY());*/
            }


        });



    }
}
