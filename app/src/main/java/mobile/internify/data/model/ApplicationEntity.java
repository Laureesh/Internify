package mobile.internify.data.model;

/*
 * Placeholder blueprint for the applications table entity.
 *
 * Intended fields later:
 * - applicationId: primary key
 * - projectId: foreign key pointing to a project
 * - applicantUserId: foreign key pointing to a user
 * - coverNote: optional application message
 * - status: pending, accepted, rejected, or withdrawn
 * - appliedAt: timestamp used in lists and sorting
 *
 * Integration contract with other files:
 * - ApplicationRepository should return lists of this type.
 * - ApplicationListViewModel should expose lists of this type.
 * - ApplicationListAdapter should bind this type into item_application.xml.
 */
@SuppressWarnings("unused")
public final class ApplicationEntity {
    private ApplicationEntity() {
        // Placeholder only. Replace with real entity fields and annotations later.
    }
}


