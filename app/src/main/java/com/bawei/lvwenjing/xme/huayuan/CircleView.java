package com.bawei.lvwenjing.xme.huayuan;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by lenovo-pc on 2017/6/6.
 */

public class CircleView extends View {

    private Paint paint;
    private float x = 100;
    private float y = 100;

    public CircleView(Context context) {
        super(context);
    }

    public CircleView(Context context, AttributeSet attrs) {
        super(context, attrs);
        //获取画笔
        paint = new Paint();
        //画笔颜色
        paint.setColor(Color.BLUE);
        //抗锯齿
        paint.setAntiAlias(true);
    }

    public CircleView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public CircleView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawCircle(x, y, 100, paint);
        super.onDraw(canvas);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                float x1 = event.getX();
                float y1 = event.getY();
                //200-100
                float v = (x1 - x) * (x1 - x) + (y1 - y) * (y1 - y);
                float juli = (float) Math.sqrt(v);
                if (juli <= 100) {

                } else {

                    return false;
                }

                break;
            case MotionEvent.ACTION_MOVE:
                this.x = event.getX();
                this.y = event.getY();
                invalidate();


                break;
            case MotionEvent.ACTION_UP:
                break;


        }

        return true;
    }

}
