package mobile.internify.activities;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import mobile.internify.R;

public final class ProjectDetailActivity extends AppCompatActivity {
    public static final String EXTRA_PROJECT_ID = "mobile.internify.extra.PROJECT_ID";
    private TextView projectDetailTitleText;
    private TextView projectDetailCompanyText;
    private TextView projectDetailDescriptionText;
    private TextView projectDetailPayText;
    private TextView projectDetailDeadlineText;
    private TextView projectDetailStatusText;
    private Button applyProjectButton;
    private Button editProjectButton;
    private Button deleteProjectButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project_detail);

        projectDetailTitleText = findViewById(R.id.projectDetailTitleText);
        projectDetailCompanyText = findViewById(R.id.projectDetailCompanyText);
        projectDetailDescriptionText = findViewById(R.id.projectDetailDescriptionText);
        projectDetailPayText = findViewById(R.id.projectDetailPayText);
        projectDetailDeadlineText = findViewById(R.id.projectDetailDeadlineText);
        projectDetailStatusText = findViewById(R.id.projectDetailStatusText);
        applyProjectButton = findViewById(R.id.applyProjectButton);
        editProjectButton = findViewById(R.id.editProjectButton);
        deleteProjectButton = findViewById(R.id.deleteProjectButton);

        int projectId = getIntent().getIntExtra(EXTRA_PROJECT_ID, -1);

        loadProject(projectId);

        applyProjectButton.setOnClickListener(v ->
                Toast.makeText(this, "Applied to project!",
                        Toast.LENGTH_SHORT).show()
        );

        editProjectButton.setOnClickListener(v ->
                Toast.makeText(this, "Edit feature coming soon",
                        Toast.LENGTH_SHORT).show()
        );

        deleteProjectButton.setOnClickListener(v -> {
            Toast.makeText(this, "Project deleted (temporary)",
                    Toast.LENGTH_SHORT).show();
            finish();
        });
    }

    private void loadProject(int projectId) {
        projectDetailTitleText.setText("Sample Project #" + projectId);
        projectDetailCompanyText.setText("Company: Internify Inc.");
        projectDetailDescriptionText.setText("This is a sample project description.");
        projectDetailPayText.setText("Pay: $100");
        projectDetailDeadlineText.setText("Deadline: 1 week");
        projectDetailStatusText.setText("Status: Open");
    }
}

