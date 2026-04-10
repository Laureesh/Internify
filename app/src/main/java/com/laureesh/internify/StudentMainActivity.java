package com.laureesh.internify;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

public class StudentMainActivity extends AppCompatActivity {

    Button aboutBtn;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_main);

        aboutBtn = findViewById(R.id.aboutBtn);

        aboutBtn.setOnClickListener(v -> {
            startActivity(new Intent(this, AboutActivity.class));
        });
    }
}
