package mobile.internify.data.model;

/*
 * Placeholder blueprint for the projects table entity.
 *
 * Intended fields later:
 * - projectId: primary key
 * - ownerUserId: the company user who created the project
 * - title: short project title
 * - description: detailed project description
 * - companyName: company display name if stored redundantly
 * - payAmount: payment or stipend value
 * - deadline: target completion or application deadline
 * - status: open, closed, filled, or archived
 * - createdAt: timestamp for sorting and history
 *
 * Integration contract with other files:
 * - ProjectRepository should return lists of this type.
 * - ProjectListViewModel should expose lists of this type.
 * - ProjectListAdapter should bind this type into item_project.xml.
 * - ProjectDetailActivity should display one instance of this type.
 * - AddProjectActivity and AddProjectDialogFragment should create this type.
 */
@SuppressWarnings("unused")
public final class ProjectEntity {
    private ProjectEntity() {
        // Placeholder only. Replace with real entity fields and annotations later.
    }
}


