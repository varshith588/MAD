package com.example.mad;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.mad.R;

public class MainActivity2 extends AppCompatActivity {


    // Declare variables as class-level fields
    private EditText editTextName;
    private Button btnSayHello;
    private TextView tvGreeting;
    private Button btnClear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this); // Enable edge-to-edge design
        setContentView(R.layout.activity_main2);

        // Apply window insets to the root view
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.MainActivity2), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Initialize views
        editTextName = findViewById(R.id.editTextName);
        btnSayHello = findViewById(R.id.btnSayHello);
        btnClear = findViewById(R.id.btnClear);
        tvGreeting = findViewById(R.id.tvGreeting);

        // Set "Say Hello" button functionality
        btnSayHello.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editTextName.getText().toString().trim();
                if (!name.isEmpty()) {
                    tvGreeting.setText("Hello, " + name + "!");
                } else {
                    tvGreeting.setText("Please enter your name!");
                }
            }
        });

        // Set "Clear" button functionality
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editTextName.setText(""); // Clear the input field
                tvGreeting.setText("Hi"); // Reset the greeting
            }
        });
    }
}
