package com.example.henriette.thevuffiapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Home extends AppCompatActivity implements View.OnClickListener {

    private Button playButton;
    private Button pictureButton;
    private Button newsletterButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        playButton = findViewById(R.id.button_play);
        pictureButton = findViewById(R.id.button_pictures);
        newsletterButton = findViewById(R.id.button_newsletter);

        playButton.setOnClickListener(this);
        pictureButton.setOnClickListener(this);
        newsletterButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_play:
                Log.i("play button", "was clicked");
                Intent intent1 = new Intent(this, Play.class);
                startActivity(intent1);
                break;
            case R.id.button_pictures:
                Log.i("picture button", "was clicked");
                Intent intent2 = new Intent(this, Pictures.class);
                startActivity(intent2);
                break;
            case R.id.button_newsletter:
                Log.i("newsletter button", "was clicked");
                Intent intent3 = new Intent(this, Newsletter.class);
                startActivity(intent3);
                break;
            default:
                break;
        }
    }
}
