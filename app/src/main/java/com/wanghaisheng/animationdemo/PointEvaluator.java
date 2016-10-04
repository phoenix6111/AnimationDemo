package com.wanghaisheng.animationdemo;

import android.animation.TypeEvaluator;

/**
 * Author: sheng on 2016/10/3 15:30
 * Email: 1392100700@qq.com
 */

public class PointEvaluator implements TypeEvaluator<Point> {
    @Override
    public Point evaluate(float fraction, Point startPoint, Point endPoint) {

        float x = startPoint.getX() + fraction*(endPoint.getX()-startPoint.getX());
        float y = startPoint.getY() + fraction*(endPoint.getY()-startPoint.getY());

        return new Point(x,y);
    }
}
