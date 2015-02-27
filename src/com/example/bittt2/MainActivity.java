
package com.example.bittt2;

import java.util.ArrayList;

import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;

public class MainActivity extends Activity {

    private ViewPager viewPager;
    private MyLinePoints linePoints;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
       // viewPager = (ViewPager) this.findViewById(R.id.viewPager);
        linePoints = (MyLinePoints) this.findViewById(R.id.points);
        linePoints.setNums(6);
        for (int i = 0; i < 6; i++) {
            ImageView iv = new ImageView(getApplicationContext());
            ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(-1, -1);
            iv.setLayoutParams(params);
            iv.setBackgroundResource(R.drawable.ic_launcher);
            views.add(iv);
        }
        PagerAdapter arg0 = new MyPagerAdapter();
        viewPager.setAdapter(arg0);
        viewPager.setCurrentItem(0);
        handler.sendEmptyMessageDelayed(100, 1000);

        viewPager.setOnPageChangeListener(new OnPageChangeListener() {
            @Override
            public void onPageSelected(int arg0) {
                //
                linePoints.setGreenPoint(arg0 % 6);
            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {
            }

            @Override
            public void onPageScrollStateChanged(int arg0) {
            }
        });
    }

    int i = 0;
    private Handler handler = new Handler() {
        public void handleMessage(android.os.Message msg) {
            viewPager.setCurrentItem(i);
            i++;
            handler.sendEmptyMessageDelayed(100, 1000);
        };
    };

    private ArrayList<View> views = new ArrayList<View>();

    class MyPagerAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            return Integer.MAX_VALUE;
        }

        @Override
        public boolean isViewFromObject(View arg0, Object arg1) {
            return arg0 == arg1;
        }

        public MyPagerAdapter() {
            super();
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView(views.get(position % 6));
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            container.addView(views.get(position % 6));
            return views.get(position % 6);
        }
    }
}
