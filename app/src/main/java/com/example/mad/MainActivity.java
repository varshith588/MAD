package com.example.mad;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Setup button listeners
        findViewById(R.id.button_mainActivity1).setOnClickListener(v -> openActivity(MainActivity1.class));
        findViewById(R.id.button_mainActivity2).setOnClickListener(v -> openActivity(MainActivity2.class));
        findViewById(R.id.button_mainActivity3a1).setOnClickListener(v -> openActivity(MainActivity3a1.class));
        findViewById(R.id.button_mainActivity3b1).setOnClickListener(v -> openActivity(MainActivity3b1.class));
        findViewById(R.id.button_mainActivity4a).setOnClickListener(v -> openActivity(MainActivity4a.class));
        findViewById(R.id.button_mainActivity5).setOnClickListener(v -> openActivity(MainActivity5.class));
        findViewById(R.id.button_assignment1a).setOnClickListener(v -> openActivity(assignment1a.class));
        findViewById(R.id.button_Mrulogo).setOnClickListener(v -> openActivity(Mrulogo.class));
        findViewById(R.id.button_mainActivity7).setOnClickListener(v -> openActivity(MainActivity7.class));
    }

    private void openActivity(Class<?> activityClass) {
        Intent intent = new Intent(MainActivity.this, activityClass);
        startActivity(intent);
    }
}
