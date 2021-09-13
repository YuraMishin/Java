package com.mishinyura.university.services.impl;

import com.mishinyura.university.dao.ClassroomDAO;
import com.mishinyura.university.domain.Classroom;
import com.mishinyura.university.services.ClassroomService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Class ClassroomServiceImpl.
 * Implements Classroom service.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 07.09.2021
 */
@Service
public class ClassroomServiceImpl implements ClassroomService {
    /**
     * ClassroomDAO.
     */
    private final ClassroomDAO classroomDAO;

    /**
     * Constructor.
     *
     * @param classroomDAO classroomDAO
     */
    public ClassroomServiceImpl(final ClassroomDAO classroomDAO) {
        this.classroomDAO = classroomDAO;
    }

    /**
     * Method finds all classrooms.
     *
     * @return List<Classroom>
     */
    @Override
    @Transactional(readOnly = true)
    public List<Classroom> findAll() {
        return this.classroomDAO.findAll();
    }

    /**
     * Method finds classroom by id.
     *
     * @param id Id
     * @return Optional<Classroom>
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<Classroom> findById(final Long id) {
        return this.classroomDAO.findById(id);
    }

    /**
     * Method saves classroom.
     *
     * @param classroom classroom
     * @return classroom
     */
    @Override
    @Transactional
    public Classroom save(final Classroom classroom) {
        return this.classroomDAO.save(classroom);
    }

    /**
     * Method deletes classroom by id.
     *
     * @param id Id
     * @return boolean
     */
    @Override
    @Transactional
    public boolean deleteById(final Long id) {
        return this.classroomDAO.deleteById(id);
    }
}
