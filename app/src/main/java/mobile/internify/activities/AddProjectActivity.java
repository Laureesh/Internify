package mobile.internify.activities;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import mobile.internify.R;

public final class AddProjectActivity extends AppCompatActivity {
    private EditText projectTitleInput;
    private EditText projectDescriptionInput;
    private EditText companyNameInput;
    private EditText projectPayInput;
    private EditText projectDeadlineInput;
    private EditText projectStatusInput;
    private Button saveProjectButton;
    private Button cancelProjectButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_project);

        projectTitleInput = findViewById(R.id.projectTitleInput);
        projectDescriptionInput = findViewById(R.id.projectDescriptionInput);
        companyNameInput = findViewById(R.id.companyNameInput);
        projectPayInput = findViewById(R.id.projectPayInput);
        projectDeadlineInput = findViewById(R.id.projectDeadlineInput);
        projectStatusInput = findViewById(R.id.projectStatusInput);

        saveProjectButton = findViewById(R.id.saveProjectButton);
        cancelProjectButton = findViewById(R.id.cancelProjectButton);

        saveProjectButton.setOnClickListener(v -> saveProject());
        cancelProjectButton.setOnClickListener(v -> finish());
    }
    private void saveProject() {
        String title = projectTitleInput.getText().toString().trim();
        String description = projectDescriptionInput.getText().toString().trim();
        String company = companyNameInput.getText().toString().trim();
        String pay = projectPayInput.getText().toString().trim();
        String deadline = projectDeadlineInput.getText().toString().trim();
        String status = projectStatusInput.getText().toString().trim();

        if (TextUtils.isEmpty(title) || TextUtils.isEmpty(description)) {
            Toast.makeText(this, "Please fill in required fields",
                    Toast.LENGTH_SHORT).show();
            return;
        }
        Toast.makeText(this, "Project Saved!", Toast.LENGTH_SHORT).show();
        finish();
    }
}


