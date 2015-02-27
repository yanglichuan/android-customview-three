
package com.example.bittt2;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.cccc.VerticalPagerAdapter;
import com.example.cccc.VerticalViewPager;
import com.example.cccc.VerticalViewPager.OnPageChangeListener;

public class MainActivity2 extends Activity {

    private VerticalViewPager viewPager;

    private ArrayList<View> views = new ArrayList<View>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
      //  viewPager = (VerticalViewPager) this.findViewById(R.id.viewPager);
        final MyLinePoints linePoints = (MyLinePoints) this.findViewById(R.id.points);
        linePoints.setNums(6);

        for (int i = 0; i < 6; i++) {
            ImageView iv = new ImageView(getApplicationContext());
            ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(-1, -1);
            iv.setLayoutParams(params);
            iv.setBackgroundResource(R.drawable.ic_launcher);
            views.add(iv);
        }
        viewPager.setAdapter(new MyPagerAdapter());
        viewPager.setOnPageChangeListener(new OnPageChangeListener() {

            @Override
            public void onPageSelected(int position) {
                linePoints.setGreenPoint(position);
            }

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    class MyPagerAdapter extends VerticalPagerAdapter {

        @Override
        public int getCount() {
            return 6;
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
            container.removeView(views.get(position));
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            container.addView(views.get(position));
            return views.get(position);
        }
    }

}
