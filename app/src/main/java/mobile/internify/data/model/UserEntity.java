package mobile.internify.data.model;

/*
 * Placeholder blueprint for the users table entity.
 *
 * Intended fields later:
 * - userId: primary key
 * - fullName: display name used across the app
 * - email: login credential and unique lookup field
 * - passwordHash or password: local login value for coursework purposes
 * - role: student or company
 * - createdAt: timestamp for account creation
 *
 * This should become a Room @Entity or a SQLite-backed model later.
 *
 * Integration contract with other files:
 * - UserRepository.authenticateUser(email, password) should return this type.
 * - LoginViewModel should use this type to decide whether login succeeded.
 * - SessionManager should save this object's userId, email, and role after login.
 * - DashboardViewModel may later expose this object for greeting text.
 */
@SuppressWarnings("unused")
public final class UserEntity {
    private UserEntity() {
        // Placeholder only. Replace with real entity fields and annotations later.
    }
}


