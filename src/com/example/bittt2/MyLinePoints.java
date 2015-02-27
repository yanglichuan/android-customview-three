
package com.example.bittt2;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import android.view.View;


public class MyLinePoints extends View {

    public MyLinePoints(Context context) {
        super(context);
        init();
    }

    public MyLinePoints(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public MyLinePoints(Context context, AttributeSet attrs) {
        super(context, attrs);

        init();
    }

    // 这是默认的
    private int suggestW = 60;
    private int suggestH = 20;
    /**
     * 初始化函数
     */
    private Paint paint;

    public void init() {
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStyle(Style.FILL);
        paint.setColor(defaultColor);
        paint.setStrokeWidth(3);

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

    private int points_num = 5;// test
    private int defaultColor = Color.GRAY;
    private int point_green = 0;// index

    @Override
    protected void onDraw(Canvas canvas) {
        paint.setAntiAlias(true);
        int tempW = getMeasuredWidth();
        int tempH = getMeasuredHeight();
        int perW = tempW / points_num;
        
        //合适的半径
        int r = (tempH / 2 - 5) > (perW/2 -5)?(perW/2 -5):(tempH / 2 - 5);
        
        for (int i = 0; i < points_num; i++) {
            if (i == point_green) {
                paint.setColor(Color.GREEN);
            } else {
                paint.setColor(Color.GRAY);
            }
            canvas.drawCircle(perW * i + tempH / 2, tempH / 2 - 5, r, paint);
        }
    }

    public void setNums(int ps) {
        points_num = ps;
        invalidate();
    }

    public void setGreenPoint(int index) {
        point_green = index;
        invalidate();
    }

}
