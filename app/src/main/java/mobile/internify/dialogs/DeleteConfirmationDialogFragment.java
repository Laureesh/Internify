package mobile.internify.dialogs;

import android.app.Dialog;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

public final class DeleteConfirmationDialogFragment extends DialogFragment {
    public interface OnDeleteConfirmedListener {
        void onDeleteConfirmed();
    }

    private OnDeleteConfirmedListener listener;

    public void setOnDeleteConfirmedListener(OnDeleteConfirmedListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        return new AlertDialog.Builder(requireActivity())
                .setTitle("Delete Project")
                .setMessage("Are you sure you want to delete this project?")
                .setPositiveButton("Delete", (dialog, which) -> {
                    if (listener != null) {
                        listener.onDeleteConfirmed();
                    }
                })
                .setNegativeButton("Cancel", (dialog, which) ->
                        dialog.dismiss())
                .create();
    }
}


