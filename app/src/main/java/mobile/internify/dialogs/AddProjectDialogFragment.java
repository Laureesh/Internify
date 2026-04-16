package mobile.internify.dialogs;

import android.app.Dialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;
import mobile.internify.R;

public final class AddProjectDialogFragment extends DialogFragment {
    public interface OnProjectCreatedListener {
        void onProjectCreated();
    }
    private OnProjectCreatedListener listener;
    private EditText projectTitleInput;
    private EditText projectDescriptionInput;
    private EditText companyNameInput;
    private EditText projectPayInput;
    private EditText projectDeadlineInput;
    private EditText projectStatusInput;

    public void setOnProjectCreatedListener(OnProjectCreatedListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        View view = LayoutInflater.from(getActivity())
                .inflate(R.layout.dialog_add_project, null);

        projectTitleInput = view.findViewById(R.id.projectTitleInput);
        projectDescriptionInput = view.findViewById(R.id.projectDescriptionInput);
        companyNameInput = view.findViewById(R.id.companyNameInput);
        projectPayInput = view.findViewById(R.id.projectPayInput);
        projectDeadlineInput = view.findViewById(R.id.projectDeadlineInput);
        projectStatusInput = view.findViewById(R.id.projectStatusInput);

        Button saveProjectButton = view.findViewById(R.id.saveProjectButton);
        Button cancelProjectButton = view.findViewById(R.id.cancelProjectButton);

        AlertDialog dialog = new AlertDialog.Builder(requireActivity())
                .setView(view)
                .create();

        saveProjectButton.setOnClickListener(v -> saveProject(dialog));
        cancelProjectButton.setOnClickListener(v -> dialog.dismiss());

        return dialog;
    }

    private void saveProject(Dialog dialog) {
        String title = projectTitleInput.getText().toString().trim();
        String description = projectDescriptionInput.getText().toString().trim();
        String company = companyNameInput.getText().toString().trim();
        String pay = projectPayInput.getText().toString().trim();
        String deadline = projectDeadlineInput.getText().toString().trim();
        String status = projectStatusInput.getText().toString().trim();

        if (TextUtils.isEmpty(title) || TextUtils.isEmpty(description)) {
            Toast.makeText(getContext(), "Please fill required fields",
                    Toast.LENGTH_SHORT).show();
            return;
        }
        Toast.makeText(getContext(), "Project Created!", Toast.LENGTH_SHORT).show();

        if (listener != null) {
            listener.onProjectCreated();
        }
        dialog.dismiss();
    }
}


