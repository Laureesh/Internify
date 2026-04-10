package mobile.internify.fragments;

/*
 * Placeholder blueprint for the project list fragment.
 *
 * Intended responsibilities:
 * 1. Inflate fragment_project_list.xml.
 * 2. Own the RecyclerView that displays projects.
 * 3. Observe project list data from ProjectListViewModel.
 * 4. Connect ProjectListAdapter to the RecyclerView.
 * 5. Report click events back to the host activity.
 * 6. Show an empty-state view when there are no projects to display.
 *
 * Integration contract with other files:
 * - Must use layout file: fragment_project_list.xml.
 * - That layout should expose:
 *   projectRecyclerView, projectEmptyStateText, projectLoadingBar.
 * - Should own a ProjectListAdapter instance.
 * - Should observe ProjectListViewModel for project list data.
 * - Should require its host activity to implement
 *   ProjectListAdapter.OnProjectClickListener.
 * - Should submit the selected projectId back to DashboardActivity through that callback.
 *
 * Merge safety note:
 * - If your partner builds ProjectListAdapter and ProjectListViewModel,
 *   the callback interface and observable data type must match this comment.
 */
@SuppressWarnings("unused")
public final class ProjectListFragment {
    private ProjectListFragment() {
        // Placeholder only. Replace with Fragment implementation later.
    }
}


