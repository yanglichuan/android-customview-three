
package com.example.bittt2;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

public class MyColorFullRadioButton extends View {

    public MyColorFullRadioButton(Context context) {
        super(context);
        init();
    }

    public MyColorFullRadioButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public MyColorFullRadioButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray array = context
                .obtainStyledAttributes(attrs, R.styleable.MyColorFullRadioButton);
        int color = array.getColor(R.styleable.MyColorFullRadioButton_ccolor, defaultColor);
        defaultColor = color;
        array.recycle();
        init();
    }

    // 这是默认的
    private int suggestW = 60;
    private int suggestH = 60;
    /**
     * 初始化函数
     */
    private Paint paint;

    public void init() {
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStyle(Style.FILL);
        paint.setColor(Color.BLUE);
        paint.setStrokeWidth(3);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:

                break;
            case MotionEvent.ACTION_MOVE:

                break;
            case MotionEvent.ACTION_UP:
                setChecked(!bchecked);
                break;
            default:
                break;
        }
        return true;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(measureWidth(widthMeasureSpec),
                measureHeight(heightMeasureSpec));
    }

    private int measureWidth(int measureSpec) {
        int result;
        int specMode = MeasureSpec.getMode(measureSpec);
        int specSize = MeasureSpec.getSize(measureSpec);

        if (specMode == MeasureSpec.EXACTLY) {
            result = specSize;
        } else {
            result = (int) (suggestW + getPaddingLeft()
                    + getPaddingRight());
            if (specMode == MeasureSpec.AT_MOST) {
                result = Math.min(result, specSize);
            }
        }

        return result;
    }

    /**
     * Determines the height of this view
     * 
     * @param measureSpec A measureSpec packed into an int
     * @return The height of the view, honoring constraints from measureSpec
     */
    private int measureHeight(int measureSpec) {
        int result;
        int specMode = MeasureSpec.getMode(measureSpec);
        int specSize = MeasureSpec.getSize(measureSpec);

        if (specMode == MeasureSpec.EXACTLY) {
            result = specSize;
        } else {
            result = suggestH + getPaddingTop()
                    + getPaddingBottom();
            if (specMode == MeasureSpec.AT_MOST) {
                // Respect AT_MOST value if that was what is called for by
                // measureSpec
                result = Math.min(result, specSize);
            }
        }
        return result;
    }

    private int defaultColor = Color.BLUE;
    private int disableColor = Color.GRAY;

    @Override
    protected void onDraw(Canvas canvas) {
        paint.setAntiAlias(true);
        if (bchecked) {
            paint.setColor(defaultColor);
        } else {
            paint.setColor(disableColor);
        }
        paint.setStyle(Style.FILL);
        int tempW = getMeasuredWidth();
        int tempH = getMeasuredHeight();
        canvas.drawCircle(tempW / 2, tempW / 2, tempW / 2, paint);

        if (!bchecked) {
            return;
        }

        paint.setColor(Color.WHITE);
        paint.setStyle(Style.STROKE);
        paint.setStrokeJoin(Join.ROUND);
        paint.setShadowLayer(5, tempW / 2, tempW / 2, Color.GREEN);
        paint.setStrokeWidth(6);
        Path path = new Path();
        int x1 = tempW / 2 - tempW / 4;
        int y1 = tempW / 2 - tempW / 6;

        int x2 = tempW / 2;
        int y2 = tempW / 2 + tempW / 6;

        int x3 = tempW / 2 + (tempW * 3) / 4;
        int y3 = tempW / 2 - (tempW * 3) / 4;
        path.moveTo(x1, y1);
        path.lineTo(x2, y2);
        path.lineTo(x3, y3);
        canvas.drawPath(path, paint);
    }

    public boolean bchecked = true;

    public void setChecked(boolean bChecked) {
        bchecked = bChecked;
        if (listner != null) {
            listner.onChecked(bChecked);
        }
        invalidate();
    }

    //
    public OnCheckedDDDDListner listner;

    public interface OnCheckedDDDDListner {
        public void onChecked(boolean b);
    }

    public void setListner(OnCheckedDDDDListner l) {
        this.listner = l;
    }

}
