package mobile.internify.dialogs;

/*
 * Placeholder blueprint for a reusable delete confirmation dialog.
 *
 * Intended responsibilities:
 * 1. Show a warning before deleting a record.
 * 2. Display a title, message, confirm button, and cancel button.
 * 3. Accept an item ID and item type through arguments later.
 * 4. Notify the calling screen only when the user confirms deletion.
 *
 * Integration contract with other files:
 * - Should accept argument keys:
 *   ARG_ITEM_ID, ARG_ITEM_TYPE, ARG_DIALOG_TITLE, ARG_DIALOG_MESSAGE.
 * - Should report confirmation through callback interface:
 *   OnDeleteConfirmedListener with method
 *   void onDeleteConfirmed(long itemId, String itemType).
 * - ProjectDetailActivity will likely use this for deleting a project.
 * - DashboardActivity could also reuse it for deleting list items later.
 *
 * Merge safety note:
 * - If your partner builds the delete logic in repositories, both sides should
 *   agree on itemType values such as "project" and "application".
 */
@SuppressWarnings("unused")
public final class DeleteConfirmationDialogFragment {
    private DeleteConfirmationDialogFragment() {
        // Placeholder only. Replace with DialogFragment implementation later.
    }
}


