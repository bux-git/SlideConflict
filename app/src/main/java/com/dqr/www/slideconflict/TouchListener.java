package com.dqr.www.slideconflict;

import android.graphics.Rect;
import android.support.v4.view.ViewPager;
import android.view.MotionEvent;
import android.view.View;

/**
 * Description：
 * Author：LiuYM
 * Date： 2017-02-23 9:55
 */

public class TouchListener implements View.OnTouchListener {
    private static final String TAG = "TouchListener";
    private ViewPager mViewPager;
    float startX;//触摸开始X坐标
    float endX;//触摸move坐标

    int width;
    int height;

    public TouchListener(ViewPager viewPager) {
        mViewPager = viewPager;

        width = viewPager.getContext().getResources().getDisplayMetrics().widthPixels;
        height = viewPager.getContext().getResources().getDisplayMetrics().heightPixels;
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                startX = event.getX();
                break;
            case MotionEvent.ACTION_MOVE:
                if (!isInsideParent(mViewPager)) break;
                endX = event.getX();
                if (endX - startX > 0) {//向右滑动时 当页面为第一个时 滑动parent
                    if (mViewPager.getCurrentItem() > 0) {
                        mViewPager.getParent().requestDisallowInterceptTouchEvent(true);
                    } else {
                        mViewPager.getParent().requestDisallowInterceptTouchEvent(false);
                    }
                } else if (endX - startX < 0) {//向左滑动 当页面为最后一个时 滑动parent
                    if (mViewPager.getCurrentItem() < mViewPager.getAdapter().getCount() - 1) {
                        mViewPager.getParent().requestDisallowInterceptTouchEvent(true);
                    } else {
                        mViewPager.getParent().requestDisallowInterceptTouchEvent(false);
                    }
                } else {//其他都不禁止拦截
                    mViewPager.getParent().requestDisallowInterceptTouchEvent(false);
                }
                break;
        }
        return false;
    }

    /**
     * 子View是否完整显示在屏幕中
     * 判断左上角 X Y  右下角 XY 是否在父坐标之内
     *
     * @return
     */
    private boolean isInsideParent(View view) {
        Rect rt = new Rect();
        view.getGlobalVisibleRect(rt);
        boolean result = false;

        if (rt.left > 0 && rt.right < width
                && rt.top > 0 && rt.bottom < height) {
            result = true;
        }
        return result;
    }
}
