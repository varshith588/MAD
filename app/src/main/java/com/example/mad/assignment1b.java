package com.example.mad;

import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class assignment1b extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assingnment1b);

        Faculty faculty = (Faculty) getIntent().getSerializableExtra("key");

        String name = "Name: <b>" + faculty.getName() + "</b>";
        String designation = "Designation: <b>" + faculty.getDesignation() + "</b>";
        String gender = "Gender: <b>" + faculty.getGender() + "</b>";
        String dateOfJoin = "Date of Joining: <b>" + faculty.getDate_of_join() + "</b>";

        String experience = "Experience: <b>" + calculateExperience(faculty.getDate_of_join()) + "</b>";

        TextView textViewName = findViewById(R.id.textViewName);
        textViewName.setText(Html.fromHtml(name));

        TextView textViewDesignation = findViewById(R.id.textViewDesignation);
        textViewDesignation.setText(Html.fromHtml(designation));

        TextView textViewGender = findViewById(R.id.textViewGender);
        textViewGender.setText(Html.fromHtml(gender));

        TextView textViewDateOfJoin = findViewById(R.id.textViewDateOfJoin);
        textViewDateOfJoin.setText(Html.fromHtml(dateOfJoin));

        TextView textViewExperience = findViewById(R.id.textViewExperience);
        textViewExperience.setText(Html.fromHtml(experience));
    }

    private String calculateExperience(String dateOfJoining) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        try {
            // Parse the joining date
            Date joiningDate = dateFormat.parse(dateOfJoining);

            // Get the current date
            Calendar currentDate = Calendar.getInstance();
            Calendar joinDate = Calendar.getInstance();
            joinDate.setTime(joiningDate);

            // Calculate the difference
            int years = currentDate.get(Calendar.YEAR) - joinDate.get(Calendar.YEAR);
            int months = currentDate.get(Calendar.MONTH) - joinDate.get(Calendar.MONTH);
            int days = currentDate.get(Calendar.DAY_OF_MONTH) - joinDate.get(Calendar.DAY_OF_MONTH);

            // Adjust for negative values
            if (days < 0) {
                months--;
                joinDate.add(Calendar.MONTH, 1);
                days += joinDate.getActualMaximum(Calendar.DAY_OF_MONTH);
            }

            if (months < 0) {
                years--;
                months += 12;
            }

            return years + " years, " + months + " months, " + days + " days";
        } catch (ParseException e) {
            e.printStackTrace();
            return "Invalid Date";
        }
    }
}
