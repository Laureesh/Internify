package mobile.internify.data.local;

/*
 * Placeholder blueprint for the app database holder.
 *
 * Intended responsibilities:
 * 1. Represent the single database entry point for the app.
 * 2. Expose UserDao, ProjectDao, and ApplicationDao.
 * 3. Be created as a singleton so multiple database instances are avoided.
 * 4. Use Room or a custom SQLiteOpenHelper implementation later.
 *
 * Integration contract with other files:
 * - Must expose UserDao, ProjectDao, and ApplicationDao.
 * - UserRepository should depend on UserDao from this class.
 * - ProjectRepository should depend on ProjectDao from this class.
 * - ApplicationRepository should depend on ApplicationDao from this class.
 */
@SuppressWarnings("unused")
public final class AppDatabase {
    private AppDatabase() {
        // Placeholder only. Replace with RoomDatabase or SQLite helper logic later.
    }
}


