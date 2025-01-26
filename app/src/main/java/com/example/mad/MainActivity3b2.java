package com.example.mad;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
public class MainActivity3b2 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3b2);
        Intent intent = getIntent();
        Student student = (Student) intent.getSerializableExtra("KEY");
        TextView textReceived = findViewById(R.id.textReceived);
        textReceived.setText(student.name);
    }
}