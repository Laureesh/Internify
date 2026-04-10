package mobile.internify.adapters;

/*
 * Placeholder blueprint for the project RecyclerView adapter.
 *
 * Intended responsibilities:
 * 1. Bind project data into item_project.xml rows or cards.
 * 2. Display fields like title, company, pay, and status.
 * 3. Forward click events for opening the detail screen.
 * 4. Optionally forward long-press events for edit or delete actions later.
 *
 * Integration contract with other files:
 * - Must bind ProjectEntity objects.
 * - Must inflate item_project.xml.
 * - item_project.xml should expose:
 *   projectTitleText, projectCompanyText, projectSummaryText,
 *   projectPayText, projectStatusText.
 * - Must define callback interface name:
 *   OnProjectClickListener.
 * - That interface should define:
 *   void onProjectClicked(long projectId).
 * - ProjectListFragment should create this adapter.
 * - DashboardActivity should implement the click callback.
 */
@SuppressWarnings("unused")
public final class ProjectListAdapter {
    private ProjectListAdapter() {
        // Placeholder only. Replace with RecyclerView.Adapter implementation later.
    }
}


