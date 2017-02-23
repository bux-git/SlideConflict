package com.dqr.www.slideconflict;

import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * Description：
 * Author：LiuYM
 * Date： 2017-02-22 16:29
 */

public class ViewPageAdapter extends PagerAdapter {

    public static int[] mImgResId={R.drawable.one,R.drawable.two,R.drawable.three,R.drawable.four};

    @Override
    public int getCount() {
        return mImgResId.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ImageView imageView = new ImageView(container.getContext());
        imageView.setImageResource(mImgResId[position]);
        imageView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()){
                    case MotionEvent.ACTION_UP:
                        Log.d("ImageView", "ImageView.onTouch 中 ACTION_UP ");
                        break;
                    case MotionEvent.ACTION_DOWN:
                        Log.d("ImageView", "ImageView.onTouch 中 ACTION_DOWN ");
                        break;
                }
                return false;
            }
        });
        container.addView(imageView);
        return imageView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}
