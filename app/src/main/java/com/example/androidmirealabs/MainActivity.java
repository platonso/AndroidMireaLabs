package com.example.androidmirealabs;

import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.IOException;


public class MainActivity extends AppCompatActivity {


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ImageView imageView =
                findViewById(R.id.rotateImageView);
        ObjectAnimator rotateAnim =
                ObjectAnimator.ofFloat(imageView, "rotation", 0f, 360f);
        rotateAnim.setDuration(2000);
        rotateAnim.setRepeatCount(ObjectAnimator.INFINITE);
        rotateAnim.setRepeatMode(ObjectAnimator.RESTART);
        rotateAnim.start();
    }

}