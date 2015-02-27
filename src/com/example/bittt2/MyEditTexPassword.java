
package com.example.bittt2;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.os.Handler;
import android.text.Editable;
import android.text.InputType;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.TranslateAnimation;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MyEditTexPassword extends RelativeLayout {

    public MyEditTexPassword(Context context) {
        super(context);
        init();
    }

    public MyEditTexPassword(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private EditText ett;
    private ToggleButton tgg;

    public MyEditTexPassword(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public void init() {
        View view = View.inflate(this.getContext(), R.layout.edittext_password, null);
        RelativeLayout.LayoutParams params = new LayoutParams(-1, -2);
        this.addView(view, params);
        ett = (EditText) view.findViewById(R.id.ett);

        tgg = (ToggleButton) view.findViewById(R.id.tgg);
        tgg.setOnCheckedChangeListener(new OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Log.i("fifi", "isChecked=" + isChecked);
                if (isChecked) {
                    // 显示密码
                    ett.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                }
                else {
                    // 隐藏密码
                    ett.setInputType(InputType.TYPE_CLASS_TEXT
                            | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                }
            }
        });
    }
}
