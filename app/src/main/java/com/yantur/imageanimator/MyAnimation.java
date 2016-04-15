package com.yantur.imageanimator;

import android.animation.Animator;
import android.os.HandlerThread;
import android.widget.ImageView;

/**
 * Created by Artur on 4/14/2016.
 */
public class MyAnimation implements Animator.AnimatorListener {
    private ImageView imageView;
    private float scaleX, scaleY;

    public MyAnimation(ImageView imageView, float scaleX, float scaleY) {
        this.imageView = imageView;
        this.scaleX = scaleX;
        this.scaleY = scaleY;
    }

    @Override
    public void onAnimationStart(Animator animation) {

    }

    @Override
    public void onAnimationEnd(Animator animation) {
        imageView.animate().setDuration(2000).scaleX(scaleX).scaleY(scaleY).setListener(null).start();
    }

    @Override
    public void onAnimationCancel(Animator animation) {

    }

    @Override
    public void onAnimationRepeat(Animator animation) {

    }
}
