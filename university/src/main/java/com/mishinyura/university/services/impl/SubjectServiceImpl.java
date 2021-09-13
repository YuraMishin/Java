package com.mishinyura.university.services.impl;

import com.mishinyura.university.dao.SubjectDAO;
import com.mishinyura.university.domain.Subject;
import com.mishinyura.university.services.SubjectService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Class SubjectServiceImpl.
 * Implements Subject service.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 05.09.2021
 */
@Service
public class SubjectServiceImpl implements SubjectService {
    /**
     * SubjectDAO.
     */
    private final SubjectDAO subjectDAO;

    /**
     * Constructor.
     *
     * @param subjectDAO SubjectDAO
     */
    public SubjectServiceImpl(final SubjectDAO subjectDAO) {
        this.subjectDAO = subjectDAO;
    }

    /**
     * Method finds all subjects.
     *
     * @return List<Subject>
     */
    @Override
    @Transactional(readOnly = true)
    public List<Subject> findAll() {
        return this.subjectDAO.findAll();
    }

    /**
     * Method finds subject by id.
     *
     * @param id Id
     * @return Optional<Subject>
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<Subject> findById(final Long id) {
        return this.subjectDAO.findById(id);
    }

    /**
     * Method saves subject.
     *
     * @param subject Subject
     * @return Subject
     */
    @Override
    @Transactional
    public Subject save(final Subject subject) {
        return this.subjectDAO.save(subject);
    }

    /**
     * Method deletes subject by id.
     *
     * @param id Id
     * @return boolean
     */
    @Override
    @Transactional
    public boolean deleteById(final Long id) {
        return this.subjectDAO.deleteById(id);
    }
}
