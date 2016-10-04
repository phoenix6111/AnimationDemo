package com.wanghaisheng.animationdemo;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import static android.animation.ObjectAnimator.ofFloat;
import static java.lang.Math.cos;
import static java.lang.Math.sin;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    int[] mImageIds = {R.id.iv1,R.id.iv2,R.id.iv3,R.id.iv4,R.id.iv5,R.id.iv6,R.id.iv7,R.id.iv8};
    List<ImageView> imgs = new ArrayList<>();

    //菜单是否打开
    private boolean isMenuOpened;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
        setContentView(R.layout.myanim_layout);
//        for(int id : mImageIds) {
//            ImageView imageView = (ImageView) findViewById(id);
//            imageView.setOnClickListener(this);
//            imgs.add(imageView);
//        }



    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv8:
                toggleMenu2();
                break;
            default:

                break;
        }
    }

    private void toggleMenu() {
        if(!isMenuOpened) {
            for(int i=0; i<imgs.size()-1; i++) {
                ImageView iv = imgs.get(i);
                ObjectAnimator animator = ofFloat(iv,"translationY",0,90*(i+1));
                animator.setDuration(500).start();
            }
            isMenuOpened = true;
        } else {
            for(int i=0; i<imgs.size()-1; i++) {
                ImageView iv = imgs.get(i);
                ObjectAnimator animator = ofFloat(iv,"translationY",90*(i+1),0);
                animator.setDuration(500).start();
            }
            isMenuOpened = false;
        }
    }

    private void toggleMenu2() {
        if(!isMenuOpened) {
            for(int i=0; i<imgs.size()-1; i++) {
                ImageView iv = imgs.get(i);
                PropertyValuesHolder animX = PropertyValuesHolder.ofFloat("translationX",0,(float)(150* cos(Math.PI * 2 / (imgs.size() - 2) * i)));
                PropertyValuesHolder animY = PropertyValuesHolder.ofFloat("translationY",0,(float)(150* sin(Math.PI * 2 / (imgs.size() - 2) * i)));
                ObjectAnimator.ofPropertyValuesHolder(iv,animX,animY).setDuration(500).start();
            }
            isMenuOpened = true;
        } else {
            for(int i=0; i<imgs.size()-1; i++) {
                ImageView iv = imgs.get(i);
                PropertyValuesHolder animX = PropertyValuesHolder.ofFloat("translationX",(float)(150* cos(Math.PI * 2 / (imgs.size() - 2) * i)),0);
                PropertyValuesHolder animY = PropertyValuesHolder.ofFloat("translationY",(float)(150* sin(Math.PI * 2 / (imgs.size() - 2) * i)),0);
                ObjectAnimator.ofPropertyValuesHolder(iv,animX,animY).setDuration(500).start();
            }
            isMenuOpened = false;
        }
    }
}
