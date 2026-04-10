package com.laureesh.internify;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {
    Spinner roleSpinner;
    Button registerBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        roleSpinner = findViewById(R.id.roleSpinner);
        registerBtn = findViewById(R.id.registerBtn);

        String[] roles = {"student", "company"};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_dropdown_item,
                roles
        );

        roleSpinner.setAdapter(adapter);

        registerBtn.setOnClickListener(v -> {
            String role = roleSpinner.getSelectedItem().toString();

            if (role.equals("student")) {
                startActivity(new Intent(this, StudentMainActivity.class));
            } else {
                startActivity(new Intent(this, CompanyMainActivity.class));
            }
        });
    }
}
