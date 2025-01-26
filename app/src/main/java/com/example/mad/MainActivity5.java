
package com.example.mad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity5 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
    }

    public void SendSMS(View view){
        EditText textMobileNo = findViewById(R.id.textMobileNo);
        EditText textMessage = findViewById(R.id.textMessage);
        String mobileNo = textMobileNo.getText().toString();
        String message = textMessage.getText().toString();
        Intent intent=new Intent(Intent.ACTION_VIEW,
                Uri.fromParts("sms",mobileNo,null));
        intent.putExtra("sms_body",message);
        startActivity(intent);
    }
} 