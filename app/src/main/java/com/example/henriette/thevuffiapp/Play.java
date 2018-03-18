package com.example.henriette.thevuffiapp;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Play extends AppCompatActivity implements View.OnClickListener, View.OnTouchListener {

    private ImageView frisbeePicture;
    private ImageView dogPicture;
    private float x;
    private float y;
    private float distance;
    private ObjectAnimator dogAnimator;
    private SensorManager mSensorManager;
    private Sensor mSensor;
    private float mXDpi;
    private float mYDpi;

    private Button upButton;
    private Button downButton;
    private Button leftButton;
    private Button rightButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        frisbeePicture = findViewById(R.id.imageViewFrisbee);
        dogPicture = findViewById(R.id.imageViewXS);
        distance = 20;

        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        mSensor = mSensorManager.getDefaultSensor(Sensor.TYPE_LINEAR_ACCELERATION);

        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        mXDpi = metrics.widthPixels;
        mYDpi = metrics.heightPixels;
        Log.i("display width", String.valueOf(mXDpi));
        Log.i("display height", String.valueOf(mYDpi));

        upButton = findViewById(R.id.buttonUp);
        downButton = findViewById(R.id.buttonDown);
        leftButton = findViewById(R.id.buttonLeft);
        rightButton = findViewById(R.id.buttonRight);

        upButton.setOnClickListener(this);
        downButton.setOnClickListener(this);
        leftButton.setOnClickListener(this);
        rightButton.setOnClickListener(this);

        upButton.setOnTouchListener(this);
        downButton.setOnTouchListener(this);
        leftButton.setOnTouchListener(this);
        rightButton.setOnTouchListener(this);


    }

    public void movingPicture(View view) {
        switch (view.getId()) {
            case R.id.buttonUp:
                Log.i("up button", "was clicked");
                //where is the picture now? What are the bounds? Move it 10f up
                y = dogPicture.getTranslationY();
                //Log.i("x=", String.valueOf(x));
                y = y-distance;
                //Log.i("x=", String.valueOf(x));
                dogAnimator = ObjectAnimator.ofFloat(dogPicture, "translationY", y);
                dogAnimator.start();
                break;
            case R.id.buttonDown:
                Log.i("down button", "was clicked");
                y = dogPicture.getTranslationY();
                //Log.i("x=", String.valueOf(x));
                y = y+distance;
                //Log.i("x=", String.valueOf(x));
                dogAnimator = ObjectAnimator.ofFloat(dogPicture, "translationY", y);
                dogAnimator.start();
                break;
            case R.id.buttonLeft:
                Log.i("left button", "was clicked");
                x = dogPicture.getTranslationX();
                //Log.i("x=", String.valueOf(x));
                x = x-distance;
                //Log.i("x=", String.valueOf(x));
                dogAnimator = ObjectAnimator.ofFloat(dogPicture, "translationX", x);
                dogAnimator.start();
                break;
            case R.id.buttonRight:
                Log.i("right button", "was clicked");
                x = dogPicture.getTranslationX();
                //Log.i("x=", String.valueOf(x));
                x = x+distance;
                //Log.i("x=", String.valueOf(x));
                dogAnimator = ObjectAnimator.ofFloat(dogPicture, "translationX", x);
                dogAnimator.setDuration(500);
                dogAnimator.start();
                break;
            default:
                break;
        }
    }



    @Override
    public void onClick(View view) {
        movingPicture(view);
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        movingPicture(view);
        return false;
    }


}
