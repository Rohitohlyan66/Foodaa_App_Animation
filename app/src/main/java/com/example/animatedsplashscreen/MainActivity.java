package com.example.animatedsplashscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;

public class MainActivity extends AppCompatActivity {

    LottieAnimationView lottieAnimationView;
    LottieAnimationView tick;
    Button orderFood;
    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lottieAnimationView = findViewById(R.id.animation);
        orderFood = findViewById(R.id.order_button);
        tick = findViewById(R.id.animation2);
        text = findViewById(R.id.text);

        //No Status Bar-------->
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);


        //Click Listener on Order Button
        orderFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lottieAnimationView.animate().translationX(1600).setDuration(1000);
                orderFood.setVisibility(View.INVISIBLE);
                orderFood.setClickable(false);


                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        tick.setVisibility(View.VISIBLE);
                        text.setVisibility(View.VISIBLE);
                    }
                }, 1000);

            }
        });

    }
}