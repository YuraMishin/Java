package com.mishinyura.university.dao.mappers;

import com.mishinyura.university.dao.SubjectDAO;
import com.mishinyura.university.dao.impl.ClassroomDAOImpl;
import com.mishinyura.university.dao.impl.GroupDAOImpl;
import com.mishinyura.university.dao.impl.TimeDAOImpl;
import com.mishinyura.university.domain.Schedule;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Class SubjectRowMapper.
 * Implements subject row mapper.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 30.08.2021
 */
@Component("scheduleRowMapper")
public class ScheduleRowMapper implements RowMapper<Schedule> {
    /**
     * GroupDAOImpl.
     */
    private final GroupDAOImpl groupDAO;
    /**
     * SubjectDAO.
     */
    private final SubjectDAO subjectDAO;
    /**
     * TimeDAOImpl.
     */
    private final TimeDAOImpl timeDAO;
    /**
     * ClassroomDAOImpl.
     */
    private final ClassroomDAOImpl classroomDAO;

    /**
     * Constructor.
     *
     * @param groupDAO     groupDAO
     * @param subjectDAO   subjectDAO
     * @param timeDAO      timeDAO
     * @param classroomDAO classroomDAO
     */
    public ScheduleRowMapper(
        final GroupDAOImpl groupDAO,
        final SubjectDAO subjectDAO,
        final TimeDAOImpl timeDAO,
        final ClassroomDAOImpl classroomDAO) {

        this.groupDAO = groupDAO;
        this.subjectDAO = subjectDAO;
        this.timeDAO = timeDAO;
        this.classroomDAO = classroomDAO;
    }

    /**
     * @param rs ResultSet
     * @param i  I
     * @return Schedule
     * @throws SQLException SQLException
     */
    @Override
    public Schedule mapRow(final ResultSet rs, final int i)
        throws SQLException {
        var groupId = rs.getLong("group_id");
        var subjectId = rs.getLong("subject_id");
        var timeId = rs.getLong("time_id");
        var classroomId = rs.getLong("classroom_id");
        var group = groupDAO.findById(groupId).get();
        var subject = subjectDAO.findById(subjectId).get();
        var day = rs.getInt("day");
        var time = timeDAO.findById(timeId).get();
        var classroom = classroomDAO.findById(classroomId).get();

        return new Schedule(
            rs.getLong("id"),
            group,
            subject,
            day,
            time,
            classroom
        );
    }
}
