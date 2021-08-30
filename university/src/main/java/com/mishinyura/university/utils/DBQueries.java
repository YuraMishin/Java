package com.mishinyura.university.utils;

/**
 * Class DBQueries.
 * Implements DB SQL qeries list.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 29.08.2021
 */
public final class DBQueries {
    // UserDAOImpl
    /**
     * ALL_USERS.
     */
    public static final String ALL_USERS;
    /**
     * USER_BY_ID.
     */
    public static final String USER_BY_ID;
    /**
     * CREATE_USER.
     */
    public static final String CREATE_USER;
    /**
     * UPDATE_USER.
     */
    public static final String UPDATE_USER;
    /**
     * DELETE_USER.
     */
    public static final String DELETE_USER;
    //
    // SubjectDAOImpl
    /**
     * ALL_SUBJECTS.
     */
    public static final String ALL_SUBJECTS;
    /**
     * USER_BY_ID.
     */
    public static final String SUBJECT_BY_ID;
    /**
     * CREATE_SUBJECT.
     */
    public static final String CREATE_SUBJECT;
    /**
     * UPDATE_SUBJECT.
     */
    public static final String UPDATE_SUBJECT;
    /**
     * DELETE_SUBJECT.
     */
    public static final String DELETE_SUBJECT;
    //
    // GroupDAOImpl
    /**
     * ALL_GROUPS.
     */
    public static final String ALL_GROUPS;
    /**
     * USER_BY_ID.
     */
    public static final String GROUP_BY_ID;
    /**
     * CREATE_GROUP.
     */
    public static final String CREATE_GROUP;
    /**
     * UPDATE_GROUP.
     */
    public static final String UPDATE_GROUP;
    /**
     * DELETE_GROUP.
     */
    public static final String DELETE_GROUP;
    //

    static {
        ALL_USERS = ResUtils.loadText("db/sql/userDAOImpl/allUsers.sql");
        USER_BY_ID = ResUtils.loadText("db/sql/userDAOImpl/userById.sql");
        CREATE_USER = ResUtils.loadText("db/sql/userDAOImpl/createUser.sql");
        UPDATE_USER = ResUtils.loadText("db/sql/userDAOImpl/updateUser.sql");
        DELETE_USER = ResUtils.loadText("db/sql/userDAOImpl/deleteUser.sql");
        //
        ALL_SUBJECTS = ResUtils
            .loadText("db/sql/subjectDAOImpl/allSubjects.sql");
        SUBJECT_BY_ID = ResUtils
            .loadText("db/sql/subjectDAOImpl/subjectById.sql");
        CREATE_SUBJECT = ResUtils
            .loadText("db/sql/subjectDAOImpl/createSubject.sql");
        UPDATE_SUBJECT = ResUtils
            .loadText("db/sql/subjectDAOImpl/updateSubject.sql");
        DELETE_SUBJECT = ResUtils
            .loadText("db/sql/subjectDAOImpl/deleteSubject.sql");
        //
        ALL_GROUPS = ResUtils
            .loadText("db/sql/groupDAOImpl/allGroups.sql");
        GROUP_BY_ID = ResUtils
            .loadText("db/sql/groupDAOImpl/groupById.sql");
        CREATE_GROUP = ResUtils
            .loadText("db/sql/groupDAOImpl/createGroup.sql");
        UPDATE_GROUP = ResUtils
            .loadText("db/sql/groupDAOImpl/updateGroup.sql");
        DELETE_GROUP = ResUtils
            .loadText("db/sql/groupDAOImpl/deleteGroup.sql");
    }

    /**
     * Constructor.
     */
    private DBQueries() {
    }
}
