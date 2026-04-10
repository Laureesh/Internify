package mobile.internify.session;

/*
 * Placeholder blueprint for SharedPreferences-backed session storage.
 *
 * Intended responsibilities:
 * 1. Save the logged-in user ID after authentication.
 * 2. Save the logged-in user email and role if helpful for quick access.
 * 3. Report whether a user is currently logged in.
 * 4. Clear all saved session values during logout.
 * 5. Serve as the only class that talks directly to SharedPreferences.
 *
 * Integration contract with other files:
 * - LoginActivity should call saveLoginSession(...) after successful authentication.
 * - DashboardActivity should call isLoggedIn() before showing protected screens.
 * - DashboardActivity and DashboardViewModel should call getLoggedInUserId()
 *   and getLoggedInUserRole() when loading user-specific data.
 * - Logout menu action should call clearSession().
 *
 * Expected method names:
 * - saveLoginSession(long userId, String email, String role)
 * - isLoggedIn()
 * - getLoggedInUserId()
 * - getLoggedInUserEmail()
 * - getLoggedInUserRole()
 * - clearSession()
 */
@SuppressWarnings("unused")
public final class SessionManager {
    private SessionManager() {
        // Placeholder only. Replace with SharedPreferences logic later.
    }
}


