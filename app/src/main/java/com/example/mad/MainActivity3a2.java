package com.example.mad;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
public class MainActivity3a2 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3a2);
        String name = getIntent().getExtras().getString("name");
        TextView textReceived = findViewById(R.id.textReceived);
        textReceived.setText(name);
    }
}