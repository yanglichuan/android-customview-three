
package com.example.bittt2;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

public class MyRedPoint extends View {

    public MyRedPoint(Context context) {
        super(context);
        init();
    }

    public MyRedPoint(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public MyRedPoint(Context context, AttributeSet attrs) {
        super(context, attrs);

        init();
    }

    // 这是默认的
    private int suggestW = 60;
    private int suggestH = 30;
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

    private int defaultColor = Color.RED;
    private String code = "0";
    private boolean findTextSize = true;
    private boolean findTextSpace = true;
    public void setCode(String s){
        this.code = s;
        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        paint.setAntiAlias(true);
        int tempW = getMeasuredWidth();
        int tempH = getMeasuredHeight();

        Bitmap roundRectImage = createBlackImage(new RectF(0, 0, tempW, tempH), 20);
        canvas.drawBitmap(roundRectImage, 0, 0, paint);

        if(!bShowCode){
            return;
        }
        Typeface font = Typeface.create(Typeface.SANS_SERIF, Typeface.BOLD);
        paint.setTypeface(font);

        int i = 10;
        while (findTextSize) {
            paint.setTextSize(i++);
            FontMetrics sF = paint.getFontMetrics();
            int textH = (int) Math.ceil(sF.descent - sF.top) + 2;
            float scale = (float) tempH / (float) (textH);
            Log.i("bibi", "scale" + scale + "   " + tempH + "  " + textH);
            if (scale > 1 && scale < 1.3) {
                findTextSize = false;
                Log.i("bibi", "outgoing");
                break;
            }
        }

        if (TextUtils.isEmpty(code)) {
            code = "8888";
        }
        char[] array = code.toCharArray();
        int perW = getMeasuredWidth() / array.length;

        int j = 0;
        for (char c : array) {
            FontMetrics sF = paint.getFontMetrics();
            int H = (int) Math.ceil(sF.descent - sF.top) + 2;
            canvas.drawText(new String(new char[] {
                c
            }), perW * j + 5, (getMeasuredHeight() + H / 2) / 2, paint);
            j++;
        }
    }

    public void setText(String str) {
        code = str;
    }
    
    private boolean bShowCode =false;
    public void showCode(boolean b){
        this.bShowCode = b;
    }

    private Bitmap createBlackImage(RectF min, int round_radius)
    {
        final Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStyle(Style.FILL);
        paint.setColor(defaultColor);
        Bitmap target = Bitmap
                .createBitmap((int) min.width(), (int) min.height(), Config.ARGB_8888);
        /**
         * 产生一个同样大小的画布
         */
        Canvas canvas = new Canvas(target);
        /**
         * 首先绘制圆形
         */
        canvas.drawRoundRect(min, round_radius, round_radius, paint);

        return target;
    }

}
