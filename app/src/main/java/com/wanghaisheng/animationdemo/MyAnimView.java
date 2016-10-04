package com.wanghaisheng.animationdemo;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Author: sheng on 2016/10/3 15:32
 * Email: 1392100700@qq.com
 */

public class MyAnimView extends View {

    private Point mCurrentPoint;

    private float mRadius = 50f;

    private Paint mPaint;

    private String color;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
        //改变画笔的颜色
        mPaint.setColor(Color.parseColor(color));
        //重绘
        invalidate();
    }

    public MyAnimView(Context context) {
        this(context,null);
    }

    public MyAnimView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public MyAnimView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        mPaint = new Paint();
        mPaint.setColor(Color.BLUE);
        mPaint.setAntiAlias(true);
        mPaint.setDither(true);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        if(mCurrentPoint == null) {
            mCurrentPoint = new Point(mRadius,mRadius);
            drawCircle(canvas);
            startAnim();
        } else {
            drawCircle(canvas);
        }
    }

    /**
     * 画圆
     * @param canvas
     */
    private void drawCircle(Canvas canvas) {
        canvas.drawCircle(mCurrentPoint.getX(),mCurrentPoint.getY(),mRadius,mPaint);
    }

    private void startAnim() {
        Point startPoint = new Point(mRadius,mRadius);
        Point endPoint = new Point(getWidth()-mRadius,getHeight()-mRadius);

        ValueAnimator animator = ValueAnimator.ofObject(new PointEvaluator(),startPoint,endPoint);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                mCurrentPoint = (Point) animation.getAnimatedValue();
                invalidate();
            }
        });

        ObjectAnimator animator2 = ObjectAnimator.ofObject(this,"color",new ColorEvaluator(),"#0000FF", "#FF0000");
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(5000).playTogether(animator,animator2);
        animatorSet.start();
    }
}
