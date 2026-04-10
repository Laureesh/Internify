package mobile.internify.dialogs;

/*
 * Placeholder blueprint for the add-project dialog.
 *
 * Intended responsibilities:
 * 1. Inflate dialog_add_project.xml inside a dialog container.
 * 2. Provide a compact project creation form.
 * 3. Validate that required fields are present.
 * 4. Return form values to the host activity or ViewModel for saving.
 * 5. Dismiss after success or cancel.
 *
 * Integration contract with other files:
 * - Must use layout file: dialog_add_project.xml.
 * - That layout should expose:
 *   projectTitleInput, projectDescriptionInput, companyNameInput,
 *   projectPayInput, projectDeadlineInput, projectStatusInput,
 *   saveProjectButton, cancelProjectButton.
 * - Should report success through callback interface:
 *   OnProjectCreatedListener with method void onProjectCreated().
 * - DashboardActivity should implement that callback and refresh ProjectListViewModel.
 * - The saved data should map exactly to ProjectEntity field meanings.
 *
 * Merge safety note:
 * - If your partner builds ProjectEntity and ProjectRepository, the dialog must
 *   collect fields in the same order and meaning they expect.
 */
@SuppressWarnings("unused")
public final class AddProjectDialogFragment {
    private AddProjectDialogFragment() {
        // Placeholder only. Replace with DialogFragment implementation later.
    }
}


