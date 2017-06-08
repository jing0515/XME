package com.bawei.lvwenjing.xme.tupiansuofang;

import android.app.Activity;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

import com.bawei.lvwenjing.xme.R;

public class BaseZomActivity extends Activity implements View.OnTouchListener {

    private ImageView mImageView;
    //实例化保存的矩阵
    private Matrix matrix = new Matrix();
    private Matrix savedMatrix = new Matrix();
    //设置各个模式代表
    private static final int NONE = 0;
    private static final int DRAG = 1;
    private static final int ZOOM = 2;
    //设置模式
    private int mode = NONE;
    // 第一个按下的手指的点
    private PointF startPoint = new PointF();
    // 两个按下的手指的触摸点的中点
    private PointF midPoint = new PointF();
    // 初始的两个手指按下的触摸点的距离
    private float oriDis = 1f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_zom);
        //找到控件
        mImageView = (ImageView) findViewById(R.id.iv);
        mImageView.setOnTouchListener(this);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        //view类型
        ImageView view = (ImageView) v;
    //获取触摸的动作 并且让其可以多点触摸
        switch (event.getAction() & MotionEvent.ACTION_MASK) {
            //点击时候
            case MotionEvent.ACTION_DOWN:
                //保存点击的矩阵
                matrix.set(view.getImageMatrix());
                savedMatrix.set(matrix);
                startPoint.set(event.getX(), event.getY());
                //单指拖动
                mode = DRAG;
                break;
            case MotionEvent.ACTION_MOVE:
                if (mode == DRAG) {
                    //判断是一个手指拖动
                    matrix.set(savedMatrix);
                    //移动图片
                    matrix.postTranslate(event.getX() - startPoint.x, event.getY() - startPoint.y);

                } else if (mode == ZOOM) {
                    // 两个手指滑动
                    float newDist = distance(event);
                    if (newDist > 10f) {
                        matrix.set(savedMatrix);
                        float scale = newDist / oriDis;
                        //图片的缩放
                        matrix.postScale(scale, scale, midPoint.x, midPoint.y);
                    }
                }
                break;

            //多指点击
            case MotionEvent.ACTION_POINTER_DOWN:
                //两指点击事件
                oriDis = distance(event);
                //两之间距离进行处理
                if (oriDis > 15f) {
                    savedMatrix.set(matrix);
                    midPoint = middle(event);
                    //缩放状态
                    mode = ZOOM;
                }
                break;
            //多指点击松开
            case MotionEvent.ACTION_POINTER_UP:
                mode = NONE;
                break;
            case MotionEvent.ACTION_UP:
                mode = NONE;
                break;
        }

        // 设置ImageView的Matrix
        view.setImageMatrix(matrix);
        return true;
    }

    // 计算两个触摸点之间的距离
    private float distance(MotionEvent event) {
        //获取第0跟手指和第一根手指的坐标
        float x = event.getX(0) - event.getX(1);
        float y = event.getY(0) - event.getY(1);
        return (float) Math.sqrt(x * x + y * y);
    }

    // 计算两个触摸点的中点
    private PointF middle(MotionEvent event) {
        float x = event.getX(0) + event.getX(1);
        float y = event.getY(0) + event.getY(1);
        return new PointF(x / 2, y / 2);
    }
}
