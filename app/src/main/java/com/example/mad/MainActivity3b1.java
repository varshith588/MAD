package com.example.mad;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
public class MainActivity3b1 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3b1);
    }
    public void SayHello(View view){
        EditText editTextName;
        editTextName = findViewById(R.id.editTextName);
        Student student = new Student();
        student.name = editTextName.getText().toString();
        Intent intent = new Intent(MainActivity3b1.this, MainActivity3b2.class);
        intent.putExtra("KEY",student);
        startActivity(intent);
    }
}