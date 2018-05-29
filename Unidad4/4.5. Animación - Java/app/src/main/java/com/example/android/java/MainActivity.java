package com.example.android.java;

import android.animation.Animator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;
    RotateAnimation animation;
    TranslateAnimation animation2;
    ScaleAnimation animation3;
    Button translate,scale;
    boolean flag;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        translate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!flag){
                    imageView.startAnimation(animation2);
                    flag=!flag;
                }
                else {
                    imageView.setAnimation(null);
                    flag=!flag;
                }
            }
        });
        scale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!flag){
                    imageView.startAnimation(animation3);
                    flag=!flag;
                }
                else {
                    imageView.setAnimation(null);
                    flag=!flag;
                }
            }
        });


    }

    private void init(){
        flag=false;
        animation = new RotateAnimation(0f,350f,15f,15f);
        animation.setInterpolator(new LinearInterpolator());
        animation.setRepeatCount(Animation.INFINITE);
        animation.setDuration(700);

        animation2 = new TranslateAnimation(0,500,0,0);
        animation2.setInterpolator(new LinearInterpolator());
        animation2.setRepeatCount(Animation.INFINITE);
        animation2.setDuration(700);

        animation3 = new ScaleAnimation(0.0f,1.0f,0.0f,1.0f);
        animation3.setInterpolator(new LinearInterpolator());
        animation3.setRepeatCount(Animation.INFINITE);
        animation3.setDuration(700);

        imageView = (ImageView) findViewById(R.id.faceIcon);
        translate=(Button)findViewById(R.id.translate);
        scale=(Button)findViewById(R.id.scale);
    }

    public void onButtonClick(View v) {
        if(!flag){
            imageView.startAnimation(animation);
            flag=!flag;
        }
        else {
            imageView.setAnimation(null);
            flag=!flag;
        }

        /*imageView.animate()
                .sc\aleX(2)
                .scaleY(2)
                .rotationX(220)
                .rotationY(220)
                .translationX(200)
                .translationY(200)
                .setDuration(3000)
                .setListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animation) {
                        Log.i("Animation", "onAnimationStart");
                    }

                    @Override
                    public void onAnimationEnd(Animator animation) {
                        Log.i("Animation", "onAnimationEnd");
                    }

                    @Override
                    public void onAnimationCancel(Animator animation) {

                    }

                    @Override
                    public void onAnimationRepeat(Animator animation) {

                    }
                });*/
    }

}