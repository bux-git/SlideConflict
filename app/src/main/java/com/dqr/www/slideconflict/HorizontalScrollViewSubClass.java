package com.dqr.www.slideconflict;

import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.HorizontalScrollView;

/**
 * Description：
 * Author：LiuYM
 * Date： 2017-02-22 18:42
 */

public class HorizontalScrollViewSubClass extends HorizontalScrollView {
    private static final String TAG = "HorizontalScrollViewSub";
    public HorizontalScrollViewSubClass(Context context) {
        super(context);
    }

    public HorizontalScrollViewSubClass(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public HorizontalScrollViewSubClass(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public HorizontalScrollViewSubClass(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
       // Log.d(TAG, "HorizontalScrollViewSubClass.dispatchTouchEvent 中  "+ev.getAction());
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
       // Log.d(TAG, "HorizontalScrollViewSubClass.onInterceptTouchEvent 中  "+ev.getAction());
        return super.onInterceptTouchEvent(ev);
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
       // Log.d(TAG, "HorizontalScrollViewSubClass.onTouchEvent 中  "+event.getAction());
        return super.onTouchEvent(event);
    }
}
