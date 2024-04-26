package com.example.androidmirealabs;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

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

        final TextView moveText =
                findViewById(R.id.moveText);
        moveText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ObjectAnimator moveX =
                        ObjectAnimator.ofFloat(moveText, "translationX", 0f, 300f);
                moveX.setDuration(1000);

                ObjectAnimator moveY =
                        ObjectAnimator.ofFloat(moveText, "translationY", 0f, 900f);
                moveY.setDuration(1000);

                AnimatorSet moveAnim = new AnimatorSet();
                moveAnim.playTogether(moveX, moveY); // Запуск анимации по оси X и Y одновременно
                moveAnim.start();
            }
        });

    }
}