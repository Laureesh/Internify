# Internify Feature Scaffold Map

This document lists the placeholder files added for the course checklist. These files are intentionally non-functional. They exist so the project has a clean structure you can fill in later without guessing where each feature belongs.

For exact file-to-file handoff rules, matching IDs, callback names, repository method names, and screen flow, also read:

`docs/integration_contracts.md`

## Important note

Nothing in this scaffold is wired into the running app yet.

The goal of these files is:

1. To reserve the correct file names and folders in the project.
2. To explain what each file should eventually contain.
3. To show how the screens, database layer, adapters, dialogs, session storage, and ViewModel layer connect to one another.

## Screen flow

`LoginActivity` should be the app entry point for authentication.

`DashboardActivity` should be the main hub after login. It can host fragments or switch between project and application views.

`ProjectDetailActivity` should open when the user taps a project from the project list.

`AddProjectActivity` is included because your checklist mentions an add-project screen. If you decide to use only a dialog instead of a full screen, you can remove or ignore this activity later.

## Files by area

### Activities

`app/src/main/java/mobile/internify/activities/LoginActivity.java`

- Owns the login screen UI.
- Reads email and password inputs.
- Validates input before attempting login.
- Looks up the user in the local data layer.
- Saves the logged-in user using `SessionManager`.
- Sends the user to `DashboardActivity`.

`app/src/main/java/mobile/internify/activities/DashboardActivity.java`

- Acts as the post-login home screen.
- Hosts or swaps between `ProjectListFragment` and `ApplicationListFragment`.
- Owns the toolbar or overflow menu.
- Launches `AddProjectDialogFragment` or `AddProjectActivity`.
- Sends the user to `ProjectDetailActivity` when a project is selected.

`app/src/main/java/mobile/internify/activities/ProjectDetailActivity.java`

- Displays a single project in detail.
- Receives a project ID through an intent extra.
- Loads that project from the repository or database layer.
- Shows actions like apply, edit, or delete.
- Can trigger a delete confirmation dialog before removal.

`app/src/main/java/mobile/internify/activities/AddProjectActivity.java`

- Represents a full-screen version of the add-project flow.
- Useful if the assignment grader expects both a screen and a dialog concept in the app.
- Collects all project form inputs and saves a new project through the repository.

### Fragments

`app/src/main/java/mobile/internify/fragments/ProjectListFragment.java`

- Shows the main RecyclerView of projects.
- Observes project data from a ViewModel.
- Passes item-click events to the host activity.
- Supports refresh, filtering, or empty-state handling later.

`app/src/main/java/mobile/internify/fragments/ApplicationListFragment.java`

- Shows applications the current user has submitted or received.
- Uses a RecyclerView and adapter similar to the project list.
- Observes application data from its ViewModel.

### RecyclerView adapters

`app/src/main/java/mobile/internify/adapters/ProjectListAdapter.java`

- Converts project records into on-screen list rows.
- Binds project title, company, location, pay, and status fields.
- Emits click or long-press events back to the fragment or activity.

`app/src/main/java/mobile/internify/adapters/ApplicationListAdapter.java`

- Converts application records into on-screen list rows.
- Binds applicant name, project title, application date, and status fields.

### Dialogs

`app/src/main/java/mobile/internify/dialogs/AddProjectDialogFragment.java`

- Represents the modal dialog used to add a project quickly from the dashboard.
- Inflates `dialog_add_project.xml`.
- Validates required fields before submit.
- Passes confirmed data back to the host screen or ViewModel.

`app/src/main/java/mobile/internify/dialogs/DeleteConfirmationDialogFragment.java`

- Represents a reusable confirmation dialog before deleting a project or application.
- Protects against accidental deletion.
- Should receive the item ID and deletion type through arguments later.

### Room or SQLite layer

`app/src/main/java/mobile/internify/data/model/UserEntity.java`

- Blueprint for the users table.
- Should eventually hold identifiers, login info, name, role, and timestamps.

`app/src/main/java/mobile/internify/data/model/ProjectEntity.java`

- Blueprint for the projects table.
- Should eventually store project title, description, owner, pay, deadline, and status.

`app/src/main/java/mobile/internify/data/model/ApplicationEntity.java`

- Blueprint for the applications table.
- Should eventually connect a user to a project with status and application date.

`app/src/main/java/mobile/internify/data/local/AppDatabase.java`

- Central database holder.
- Should expose DAOs for users, projects, and applications.
- Should be built as a singleton so only one database instance exists.

`app/src/main/java/mobile/internify/data/local/UserDao.java`

- Should define insert, lookup, update, and delete operations for users.

`app/src/main/java/mobile/internify/data/local/ProjectDao.java`

- Should define insert, list, detail lookup, update, and delete operations for projects.

`app/src/main/java/mobile/internify/data/local/ApplicationDao.java`

- Should define insert, list-by-user, list-by-project, update-status, and delete operations for applications.

### Repository layer

`app/src/main/java/mobile/internify/data/repository/UserRepository.java`

- Sits between UI logic and the data source.
- Hides whether data comes from Room, SQLite, mock data, or network in the future.

`app/src/main/java/mobile/internify/data/repository/ProjectRepository.java`

- Central place for project CRUD logic.
- Good place for future business rules such as duplicate-title checks or role-based visibility.

`app/src/main/java/mobile/internify/data/repository/ApplicationRepository.java`

- Central place for application creation and status changes.
- Helps keep fragments and activities thin.

### Session storage

`app/src/main/java/mobile/internify/session/SessionManager.java`

- Wraps `SharedPreferences`.
- Stores the current logged-in user ID, email, and role.
- Checks whether a session exists on app startup.
- Clears the session during logout.

### ViewModel layer

`app/src/main/java/mobile/internify/viewmodel/LoginViewModel.java`

- Holds login state, validation results, and login outcome.
- Prevents login logic from living directly inside the activity.

`app/src/main/java/mobile/internify/viewmodel/DashboardViewModel.java`

- Holds dashboard-wide state.
- Can track the selected tab, current user, and summary counters.

`app/src/main/java/mobile/internify/viewmodel/ProjectListViewModel.java`

- Exposes observable project lists to `ProjectListFragment`.
- Triggers refresh and delete operations through `ProjectRepository`.

`app/src/main/java/mobile/internify/viewmodel/ApplicationListViewModel.java`

- Exposes observable application lists to `ApplicationListFragment`.
- Triggers application updates through `ApplicationRepository`.

### Layout resources

`activity_login.xml`

- Login form screen.
- Should contain logo area, email input, password input, login button, and register button.

`activity_dashboard.xml`

- Main signed-in screen.
- Should contain toolbar area, fragment container, and optional floating action button or empty state.

`activity_project_detail.xml`

- Detail screen for one selected project.
- Should contain title, description, metadata, and action buttons.

`activity_add_project.xml`

- Full-screen project form.
- Should contain all inputs required to create a project.

`fragment_project_list.xml`

- RecyclerView container for projects.
- Should also provide an empty-state message.

`fragment_application_list.xml`

- RecyclerView container for applications.
- Should also provide an empty-state message.

`dialog_add_project.xml`

- Compact form used by the add-project dialog.
- Should mirror the most important fields from the full add-project screen.

`item_project.xml`

- One row or card in the project list RecyclerView.

`item_application.xml`

- One row or card in the application list RecyclerView.

### Menu resources

`menu_dashboard.xml`

- Toolbar or overflow actions for the dashboard.
- Suggested actions: add project, open applications, logout.

## Suggested implementation order later

1. Build `UserEntity`, `ProjectEntity`, `ApplicationEntity`.
2. Build DAOs and `AppDatabase`.
3. Build `SessionManager`.
4. Build `LoginActivity`.
5. Build repositories and ViewModels.
6. Build `DashboardActivity` with `ProjectListFragment`.
7. Add RecyclerView adapters.
8. Add `ProjectDetailActivity`.
9. Add add-project and delete dialogs.
10. Add `ApplicationListFragment`.

## Why this scaffold helps

This structure makes it easier to tell your instructor:

- where each rubric item lives,
- how the app is organized,
- how the data layer connects to the UI,
- and where the bonus architecture pieces belong.
