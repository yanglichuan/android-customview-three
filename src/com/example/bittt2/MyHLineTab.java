
package com.example.bittt2;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MyHLineTab extends RelativeLayout {

    public MyHLineTab(Context context) {
        super(context);
        init();
    }

    public MyHLineTab(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private ImageView ivv;
    int titleCount;
    private int titleW = 0;

    public MyHLineTab(Context context, AttributeSet attrs) {
        super(context, attrs);
        View view = View.inflate(context, R.layout.hline_tb, null);
        RelativeLayout.LayoutParams params = new LayoutParams(-1, -2);
        this.addView(view, params);

        ivv = (ImageView) view.findViewById(R.id.hLine);
        LinearLayout layout = (LinearLayout) view.findViewById(R.id.titles);
        titleCount = layout.getChildCount();
        if (titleCount > 0) {
            final TextView tv = (TextView) layout.getChildAt(0);
            tv.getViewTreeObserver().addOnPreDrawListener(new OnPreDrawListener() {
                @Override
                public boolean onPreDraw() {
                    titleW = tv.getMeasuredWidth();
                    tv.getViewTreeObserver().removeOnPreDrawListener(this);
                    RelativeLayout.LayoutParams layoutParams = (android.widget.RelativeLayout.LayoutParams) ivv
                            .getLayoutParams();
                    layoutParams.width = titleW;
                    ivv.setLayoutParams(layoutParams);
                    return false;
                }
            });
        }
        init();
    }

    public void init() {

        handler.sendEmptyMessageDelayed(100, 2000);

    }

    public void setTabIndex(int index) {

    }

    int TTTT = 0;

    public void createTranslateAnim(int index) {
        final int ToX = index * titleW;

        TranslateAnimation ta = new TranslateAnimation(TTTT, ToX, 0, 0);
        ta.setDuration(500);
        ta.setFillAfter(true);
        ta.setFillEnabled(true);
        ivv.startAnimation(ta);
        ta.setAnimationListener(new AnimationListener() {

            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                TTTT = ToX;
            }
        });
    }

    int temp = 1;
    private Handler handler = new Handler() {
        public void handleMessage(android.os.Message msg) {
            temp++;
            if (temp == 2) {
                createTranslateAnim(2);
            }
            if (temp == 3) {
                createTranslateAnim(1);
            }
            if (temp == 4) {
                createTranslateAnim(2);
            }
            if (temp == 5) {
                createTranslateAnim(0);
            }
            if (temp == 6) {
                createTranslateAnim(1);
            }
            if (temp == 7) {
                createTranslateAnim(0);
            }
            if (temp == 8) {
                createTranslateAnim(2);
            }
            handler.sendEmptyMessageDelayed(100, 2000);
        };
    };

}
