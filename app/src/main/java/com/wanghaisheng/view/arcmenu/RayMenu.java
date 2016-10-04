package com.wanghaisheng.view.arcmenu;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;

/**
 * Author: sheng on 2016/10/1 18:57
 * Email: 1392100700@qq.com
 */

public class RayMenu extends FrameLayout {

    //子ImageView的数量
    private int mChildCount;

    //点击显示菜单时的图片resource
    private int mMenuPlus;
    //点击隐藏菜单时的图片resource
    private int mMenuMinus;

    //子菜单的margin
    private int mChildMargin;

    public RayMenu(Context context) {
        super(context);
    }

    public RayMenu(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public RayMenu(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

    }
}
