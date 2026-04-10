package mobile.internify.viewmodel;

/*
 * Placeholder blueprint for dashboard-wide screen state.
 *
 * Intended responsibilities:
 * 1. Hold information needed across the dashboard.
 * 2. Track the current user, selected section, and summary counts.
 * 3. Coordinate top-level actions like logout or screen refresh.
 *
 * Integration contract with other files:
 * - DashboardActivity should use this class as its screen-level state holder.
 * - This class may use SessionManager and UserRepository to load current user info.
 * - This class may signal whether DashboardActivity should show projects or applications.
 */
@SuppressWarnings("unused")
public final class DashboardViewModel {
    private DashboardViewModel() {
        // Placeholder only. Replace with ViewModel and LiveData later.
    }
}


