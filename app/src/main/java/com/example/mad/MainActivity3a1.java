package com.example.mad;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.mad.R;

public class MainActivity3a1 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3a1);
    }
    public void SayHello(View view){
        EditText editTextName;
        editTextName = findViewById(R.id.editTextName);
        String name = editTextName.getText().toString();
        Intent intent = new Intent(MainActivity3a1.this, MainActivity3a2.class);
        intent.putExtra("name",name);
        startActivity(intent);
    }
}