# Internify Handoff Guide

This file is the simple version of the rules for merging your work.

Read it like this:

- If a name is listed here, do not rename it.
- If one person builds the Java file and the other person builds the XML, both must use the exact same IDs from this file.
- If one person builds the UI and the other person builds the repository or database, both must use the exact same method names from this file.

If one of you changes a name, both of you must change it everywhere.

## The Main Idea

You do not want this situation:

- Jack puts `projectRecyclerView` in XML
- Lauresh writes `findViewById(R.id.projectListRecyclerView)`

That will compile badly or fail later because the names do not match.

You want this situation:

- both people use the exact same name
- both sides plug together immediately

## Do Not Rename These

### Intent extra names

- `ProjectDetailActivity.EXTRA_PROJECT_ID = "mobile.internify.extra.PROJECT_ID"`
- `DashboardActivity.EXTRA_START_DESTINATION = "mobile.internify.extra.START_DESTINATION"`

### Role strings

- `"student"`
- `"company"`

### Project status strings

- `"open"`
- `"closed"`
- `"filled"`

### Application status strings

- `"pending"`
- `"accepted"`
- `"rejected"`
- `"withdrawn"`

## Screen Rules

### Login screen

Files:

- `LoginActivity.java`
- `activity_login.xml`

Required XML IDs:

- `loginLogoImage`
- `loginTitleText`
- `emailInput`
- `passwordInput`
- `loginButton`
- `goToRegisterButton`
- `loginErrorText`

What this means:

- Whoever builds the XML must create those IDs.
- Whoever builds `LoginActivity` must use those exact IDs.

### Dashboard screen

Files:

- `DashboardActivity.java`
- `activity_dashboard.xml`
- `menu_dashboard.xml`

Required XML IDs:

- `dashboardToolbar`
- `dashboardGreetingText`
- `dashboardFragmentContainer`
- `addProjectFab`

Required menu item IDs:

- `action_add_project`
- `action_view_applications`
- `action_logout`

What this means:

- `DashboardActivity` should use `dashboardFragmentContainer` to hold fragments.
- The floating action button or menu should open the add-project flow.
- Logout should go through `SessionManager.clearSession()`.

### Project detail screen

Files:

- `ProjectDetailActivity.java`
- `activity_project_detail.xml`

Required XML IDs:

- `projectDetailTitleText`
- `projectDetailCompanyText`
- `projectDetailDescriptionText`
- `projectDetailPayText`
- `projectDetailDeadlineText`
- `projectDetailStatusText`
- `applyProjectButton`
- `editProjectButton`
- `deleteProjectButton`

What this means:

- `ProjectDetailActivity` must receive the project ID using `EXTRA_PROJECT_ID`.
- That activity should load the project using `ProjectRepository.getProjectById(projectId)`.

### Add project screen

Files:

- `AddProjectActivity.java`
- `activity_add_project.xml`

Required XML IDs:

- `projectTitleInput`
- `projectDescriptionInput`
- `companyNameInput`
- `projectPayInput`
- `projectDeadlineInput`
- `projectStatusInput`
- `saveProjectButton`
- `cancelProjectButton`

What this means:

- The full screen add-project form and the add-project dialog should use the same field names.
- That makes it easier to share logic and easier to merge.

## Fragment Rules

### Project list

Files:

- `ProjectListFragment.java`
- `fragment_project_list.xml`

Required XML IDs:

- `projectRecyclerView`
- `projectEmptyStateText`
- `projectLoadingBar`

What this means:

- The fragment should observe `ProjectListViewModel`.
- The fragment should use `ProjectListAdapter`.

### Application list

Files:

- `ApplicationListFragment.java`
- `fragment_application_list.xml`

Required XML IDs:

- `applicationRecyclerView`
- `applicationEmptyStateText`
- `applicationLoadingBar`

What this means:

- The fragment should observe `ApplicationListViewModel`.
- The fragment should use `ApplicationListAdapter`.

## RecyclerView Rules

### Project list row

Files:

- `ProjectListAdapter.java`
- `item_project.xml`

Required XML IDs:

- `projectTitleText`
- `projectCompanyText`
- `projectSummaryText`
- `projectPayText`
- `projectStatusText`

Required callback:

- interface name: `OnProjectClickListener`
- method: `void onProjectClicked(long projectId)`

What this means:

- `ProjectListAdapter` must use this callback name.
- `DashboardActivity` should implement this callback.
- When a row is tapped, the adapter passes the project ID up.

### Application list row

Files:

- `ApplicationListAdapter.java`
- `item_application.xml`

Required XML IDs:

- `applicationPrimaryText`
- `applicationSecondaryText`
- `applicationDateText`
- `applicationStatusText`

Required callback:

- interface name: `OnApplicationClickListener`
- method: `void onApplicationClicked(long applicationId)`

## Dialog Rules

### Add project dialog

Files:

- `AddProjectDialogFragment.java`
- `dialog_add_project.xml`

Required XML IDs:

- `projectTitleInput`
- `projectDescriptionInput`
- `companyNameInput`
- `projectPayInput`
- `projectDeadlineInput`
- `projectStatusInput`
- `saveProjectButton`
- `cancelProjectButton`

Required callback:

- interface name: `OnProjectCreatedListener`
- method: `void onProjectCreated()`

What this means:

- After a project is added, `DashboardActivity` or `ProjectListViewModel` should refresh the project list.

### Delete confirmation dialog

File:

- `DeleteConfirmationDialogFragment.java`

Required argument keys:

- `ARG_ITEM_ID`
- `ARG_ITEM_TYPE`
- `ARG_DIALOG_TITLE`
- `ARG_DIALOG_MESSAGE`

Required callback:

- interface name: `OnDeleteConfirmedListener`
- method: `void onDeleteConfirmed(long itemId, String itemType)`

What this means:

- `ProjectDetailActivity` can use this to confirm deleting a project.
- Later, the same dialog can also be reused for deleting an application.

## Session Rules

File:

- `SessionManager.java`

Required method names:

- `saveLoginSession(long userId, String email, String role)`
- `isLoggedIn()`
- `getLoggedInUserId()`
- `getLoggedInUserEmail()`
- `getLoggedInUserRole()`
- `clearSession()`

What this means:

- Login saves the session here.
- Dashboard checks login here.
- Logout clears the session here.

## ViewModel Rules

### LoginViewModel

Should do:

- validate email and password
- call `UserRepository.authenticateUser(email, password)`
- expose the result back to the activity

### DashboardViewModel

Should do:

- hold dashboard state
- hold current user info
- help with logout or current section selection

### ProjectListViewModel

Should do:

- call `ProjectRepository.getAllProjects()`
- expose the project list
- refresh after add or delete
- call `ProjectRepository.deleteProject(projectId)` when needed

### ApplicationListViewModel

Should do:

- call `ApplicationRepository.getApplicationsForUser(userId)`
- expose the application list

## Repository Rules

### UserRepository

Use these method names:

- `UserEntity authenticateUser(String email, String password)`
- `UserEntity getUserById(long userId)`
- `long insertUser(UserEntity user)`

### ProjectRepository

Use these method names:

- `List<ProjectEntity> getAllProjects()`
- `ProjectEntity getProjectById(long projectId)`
- `long insertProject(ProjectEntity project)`
- `void updateProject(ProjectEntity project)`
- `void deleteProject(long projectId)`

### ApplicationRepository

Use these method names:

- `List<ApplicationEntity> getApplicationsForUser(long userId)`
- `List<ApplicationEntity> getApplicationsForProject(long projectId)`
- `long insertApplication(ApplicationEntity application)`
- `void updateApplicationStatus(long applicationId, String status)`
- `void deleteApplication(long applicationId)`

## Data Model Rules

These are the field ideas both people should assume when writing code.

### UserEntity

- `long userId`
- `String fullName`
- `String email`
- `String password`
- `String role`

### ProjectEntity

- `long projectId`
- `long ownerUserId`
- `String title`
- `String description`
- `String companyName`
- `double payAmount`
- `String deadline`
- `String status`

### ApplicationEntity

- `long applicationId`
- `long projectId`
- `long applicantUserId`
- `String coverNote`
- `String status`
- `String appliedAt`

## How The App Should Flow

This is the expected flow in plain English:

1. The user logs in.
2. `LoginActivity` asks `LoginViewModel` to validate and log in.
3. `LoginViewModel` asks `UserRepository`.
4. `UserRepository` checks the users table.
5. If login works, `LoginActivity` calls `SessionManager.saveLoginSession(...)`.
6. Then the app opens `DashboardActivity`.
7. `DashboardActivity` shows `ProjectListFragment` first.
8. `ProjectListFragment` gets projects from `ProjectListViewModel`.
9. `ProjectListViewModel` gets them from `ProjectRepository`.
10. `ProjectRepository` gets them from `ProjectDao`.
11. If the user taps a project row, the app opens `ProjectDetailActivity`.
12. `ProjectDetailActivity` reads `EXTRA_PROJECT_ID` and loads that project.
13. If the user adds a project, the dashboard should refresh the list.

## Before You Merge

Both of you should quickly check these:

1. Do the XML IDs match this file exactly?
2. Do the callback names match this file exactly?
3. Do the repository method names match this file exactly?
4. Do the intent extra names match this file exactly?
5. Do the status strings and role strings match this file exactly?
6. Does the project still build?

## The Safest Rule

If you are unsure what to name something, do not invent a new name.

Check this file first and reuse the exact name already written here.
