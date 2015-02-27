
package com.example.bittt2;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.os.Handler;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.TranslateAnimation;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MyEditTextWithDelete extends RelativeLayout {

    public MyEditTextWithDelete(Context context) {
        super(context);
        init();
    }
    public MyEditTextWithDelete(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }
    private EditText ett;
    private ImageView ivv;
    public MyEditTextWithDelete(Context context, AttributeSet attrs) {
        super(context, attrs);
        View view = View.inflate(context, R.layout.edittext_delete, null);
        RelativeLayout.LayoutParams params = new LayoutParams(-1, -2);
        this.addView(view, params);
        ett = (EditText) view.findViewById(R.id.ett);
        ett.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (TextUtils.isEmpty(s)) {
                    ivv.setVisibility(INVISIBLE);
                } else {
                    ivv.setVisibility(VISIBLE);
                }
            }
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        ivv = (ImageView) view.findViewById(R.id.ivv);
        ivv.setVisibility(INVISIBLE);
        ivv.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                ett.setText("");
            }
        });

        init();
    }

    public void init() {
    }

}
