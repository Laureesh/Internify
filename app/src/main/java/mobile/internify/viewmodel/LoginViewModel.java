package mobile.internify.viewmodel;

/*
 * Placeholder blueprint for login screen state.
 *
 * Intended responsibilities:
 * 1. Hold login form validation state.
 * 2. Coordinate login attempts with UserRepository.
 * 3. Expose success, error, and loading states as observable values later.
 * 4. Keep login decision logic out of the activity.
 *
 * Integration contract with other files:
 * - LoginActivity should call this class instead of calling UserRepository directly.
 * - This class should call UserRepository.authenticateUser(email, password).
 * - On success, it should provide UserEntity data back to LoginActivity.
 * - LoginActivity should then call SessionManager.saveLoginSession(...).
 */
@SuppressWarnings("unused")
public final class LoginViewModel {
    private LoginViewModel() {
        // Placeholder only. Replace with ViewModel and LiveData later.
    }
}


