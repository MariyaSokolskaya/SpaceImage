package com.example.spaceimage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class SpaceActivity extends AppCompatActivity {
    TextView imageText, explanationText, copyrightText, titleText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageText = findViewById(R.id.image_url);
        explanationText = findViewById(R.id.explanation);
        copyrightText = findViewById(R.id.copyright);
        titleText = findViewById(R.id.title_image);


    }
}