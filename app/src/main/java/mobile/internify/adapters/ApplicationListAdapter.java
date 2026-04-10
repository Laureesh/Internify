package mobile.internify.adapters;

/*
 * Placeholder blueprint for the application RecyclerView adapter.
 *
 * Intended responsibilities:
 * 1. Bind application data into item_application.xml rows or cards.
 * 2. Display applicant name, project title, date, and status.
 * 3. Forward click events for future application detail actions.
 *
 * Integration contract with other files:
 * - Must bind ApplicationEntity objects.
 * - Must inflate item_application.xml.
 * - item_application.xml should expose:
 *   applicationPrimaryText, applicationSecondaryText,
 *   applicationDateText, applicationStatusText.
 * - Must define callback interface name:
 *   OnApplicationClickListener.
 * - That interface should define:
 *   void onApplicationClicked(long applicationId).
 * - ApplicationListFragment should create this adapter.
 */
@SuppressWarnings("unused")
public final class ApplicationListAdapter {
    private ApplicationListAdapter() {
        // Placeholder only. Replace with RecyclerView.Adapter implementation later.
    }
}


