
package com.example.bittt2;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class MyRedPointImageView extends RelativeLayout {

    public MyRedPointImageView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    private MyRedPoint pp ;
    public MyRedPointImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        RelativeLayout view = (RelativeLayout) View.inflate(context, R.layout.reppoint_zehe, this);
        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.MyRedPointImageView);
        int resourceId = array.getResourceId(R.styleable.MyRedPointImageView_backimg, R.drawable.ic_launcher);
        boolean b = array.getBoolean(R.styleable.MyRedPointImageView_showpp, false);
        ImageView childAt = (ImageView) view.findViewById(R.id.ivv);
        pp = (MyRedPoint) view.findViewById(R.id.redpp);
        if(b){
            pp.setVisibility(VISIBLE);
        }else{
            pp.setVisibility(GONE);
        }
        childAt.setImageDrawable(context.getResources().getDrawable(resourceId));
        array.recycle();
    }

    public MyRedPointImageView(Context context) {
        super(context);
    }
    
    public void showPoint(boolean b){
        if(b){
            pp.setVisibility(VISIBLE);
        }else{
            pp.setVisibility(GONE);
        }
    }
}
