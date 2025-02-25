package com.example.mad;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
public class MainActivity7 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);
        Button btnFirstFragment, btnSecondFragment;
        // get the reference of Button's
        btnFirstFragment = findViewById(R.id.fstBtn);
        btnSecondFragment = findViewById(R.id.SecBtn);
        // perform setOnClickListener event on First Button
        btnFirstFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment7a firstFragment = new Fragment7a();

                loadFragment(firstFragment);
            }
        });
        // perform setOnClickListener event on Second Button
        btnSecondFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // load Second Fragment
                loadFragment(new Fragment7b());
            }
        });
    }

    private void loadFragment(androidx.fragment.app.Fragment fragment) {
        // create a FragmentManager
        FragmentManager fm = getSupportFragmentManager();
        // create a FragmentTransaction to begin the transaction and replace the Fragment
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        // replace the FrameLayout with new Fragment
        fragmentTransaction.replace(R.id.frameLayout, fragment);
        fragmentTransaction.commit(); // save the changes
    }
}
