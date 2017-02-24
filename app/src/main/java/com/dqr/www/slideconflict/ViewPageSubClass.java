package com.dqr.www.slideconflict;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Description：
 * Author：LiuYM
 * Date： 2017-02-22 19:06
 */

public class ViewPageSubClass extends ViewPager {
    private static final String TAG = "ViewPageSubClass";
    public ViewPageSubClass(Context context) {
        super(context);
    }

    public ViewPageSubClass(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        //Log.d(TAG, "ViewPageSubClass.dispatchTouchEvent 中  "+ev.getAction());
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
       // Log.d(TAG, "ViewPageSubClass.onInterceptTouchEvent 中  "+ev.getAction());
        return super.onInterceptTouchEvent(ev);
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
       // Log.d(TAG, "ViewPageSubClass.onTouchEvent 中  "+event.getAction());
        return super.onTouchEvent(event);
    }
}
