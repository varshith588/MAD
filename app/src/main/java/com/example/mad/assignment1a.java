package com.example.mad;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import java.util.Calendar;

public class assignment1a extends AppCompatActivity implements
        DatePickerDialog.OnDateSetListener {

    Faculty faculty;
    EditText editTextName, editTextDOJ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assignment1a);

        faculty = new Faculty();

        // Initialize views
        editTextName = findViewById(R.id.editTextName);
        editTextDOJ = findViewById(R.id.editTextDOJ);

        FillState();
    }

    public void SaveData(View view) {
        // Get user inputs
        String name = editTextName.getText().toString();
        String gender = GetGender();
        String dateOfJoin = editTextDOJ.getText().toString();

        // Set data in the Faculty object
        faculty.setName(name);
        faculty.setGender(gender);
        faculty.setDate_of_join(dateOfJoin);

        // Navigate to the next activity with faculty data
        Intent intent = new Intent(assignment1a.this, assignment1b.class);
        intent.putExtra("key", faculty);
        startActivity(intent);
    }

    private String GetGender() {
        RadioGroup rbGroupGender = findViewById(R.id.rbGroupGender);
        int selectedRadioButtonId = rbGroupGender.getCheckedRadioButtonId();

        if (selectedRadioButtonId != -1) {
            RadioButton selectedRadioButton = findViewById(selectedRadioButtonId);
            return selectedRadioButton.getText().toString();
        }
        return ""; // Return empty string if no gender is selected
    }

    private void FillState() {
        String[] designations = {"Professor", "Associate Professor", "Assistant Professor"};
        Spinner spinnerState = findViewById(R.id.spinnerState);

        // Create and set ArrayAdapter
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, designations);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerState.setAdapter(adapter);

        spinnerState.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                faculty.setDesignation(parent.getItemAtPosition(position).toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // No action needed
            }
        });
    }

    public void ShowDatePicker(View view) {
        // Display DatePickerDialog
        Calendar calendar = Calendar.getInstance();
        DatePickerDialog dialog = new DatePickerDialog(
                this,
                this,
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH)
        );
        dialog.show();
    }

    @Override
    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
        monthOfYear++; // Months are indexed from 0
        String formattedDate = dayOfMonth + "/" + monthOfYear + "/" + year;
        editTextDOJ.setText(formattedDate);
        faculty.setDate_of_join(formattedDate);
    }
}
