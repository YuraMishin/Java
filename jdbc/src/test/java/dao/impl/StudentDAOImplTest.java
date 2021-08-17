package dao.impl;

import dao.mapper.StudentEntityMapperImpl;
import data.H2DataSource;
import model.Student;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.ResourceUtils;
import utils.TestUtils;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.ThrowableAssert.catchThrowable;

/**
 * Class dao.impl.StudentDAOImplTest.
 * Tests dao.impl.StudentDAOImpl class.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 17.08.2021
 */
class StudentDAOImplTest {
    /**
     * H2DataSource.
     */
    private static H2DataSource dataSource;

    /**
     * Student DAO.
     */
    private static StudentDAOImpl studentDAO;

    /**
     * MAPPER.
     */
    private static StudentEntityMapperImpl MAPPER;

    @BeforeEach
    void setup() {
        var props = TestUtils.loadPropsFromResources("db.properties");
        dataSource = new H2DataSource(props);
        studentDAO = new StudentDAOImpl();
        MAPPER = new StudentEntityMapperImpl();
    }

    @AfterEach
    void tearDown() {
        dataSource.close();
    }

    /**
     * Method creates DB Scheme.
     *
     * @param conn Connection
     */
    private void initScheme(final Connection conn) {
        var initSql = TestUtils
            .loadText("sql/init_schema.sql");
        try (var ps = conn.prepareStatement(initSql)) {
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(
                String.format("%s %s",
                    TestUtils
                        .loadText("msgs/SQLException.txt"),
                    e.getMessage()),
                e);
        }
    }

    /**
     * Tests DB Schema.
     */
    @Test
    void shouldCheckIfSchemaBuilt() throws SQLException {
        // given
        var sql = "show tables;";
        var tables = new HashSet<>();

        // when
        try (var conn = dataSource.getConnection()) {
            initScheme(conn);
            try (var ps = conn.prepareStatement(sql)) {
                try (var rs = ps.executeQuery()) {
                    while (rs.next()) {
                        tables.add(rs.getString(1));
                    }
                }
            }
        }

        // then
        assertThat(tables.size()).isEqualTo(1);
        assertThat(tables.contains("STUDENTS")).isTrue();
    }

    /**
     * Tests save() method.
     */
    @Test
    void shouldReturnSavedStudentWhenSaveNew() throws SQLException {
        //given
        var newStudent = new Student("fName", "lName");
        Student savedStudent;

        // when
        try (var conn = dataSource.getConnection()) {
            initScheme(conn);
            savedStudent = studentDAO.save(conn, newStudent);
        }

        // then
        assertThat(newStudent.getId()).isNull();
        assertThat(savedStudent).isNotNull();
        assertThat(savedStudent.getId()).isEqualTo(1L);
        assertThat(savedStudent.getFirstName())
            .isEqualTo(newStudent.getFirstName());
        assertThat(savedStudent.getLastName())
            .isEqualTo(newStudent.getLastName());
    }

    /**
     * Tests save() method.
     */
    @Test
    void shouldReturnUpdatedStudentWhenSaveExistedStudent() throws SQLException {
        //given
        var sql = ResourceUtils.loadText("sql/insertStudent.sql");
        var studentToUpdate = new Student(1L, "fName", "lName");
        Student updatedStudent;
        Student selectStudent = null;

        // when
        try (var conn = dataSource.getConnection()) {
            initScheme(conn);
            try (var ps = conn.prepareStatement(sql)) {
                ps.executeUpdate();
            }
            updatedStudent = studentDAO.save(conn, studentToUpdate);

            var sqlSelect = ResourceUtils.loadText("sql/selectAll.sql");
            try (var ps = conn.prepareStatement(sqlSelect)) {
                try (var rs = ps.executeQuery()) {
                    while (rs.next()) {
                        selectStudent = MAPPER.map(rs);
                    }
                }
            }
        }

        // then
        assertThat(updatedStudent).isNotNull();
        assertThat(selectStudent).isNotNull();
        assertThat(updatedStudent.getId()).isEqualTo(selectStudent.getId());
        assertThat(updatedStudent.getFirstName()).isEqualTo(selectStudent.getFirstName());
    }

    /**
     * Tests save() method.
     */
    @Test
    void shouldThrowExceptionWhenSaveNonExistentStudent() throws SQLException {
        // given
        var studentToUpdate = new Student(10L, "fName", "lName");
        Throwable thrown = null;

        // when
        try (var conn = dataSource.getConnection()) {
            initScheme(conn);
            thrown = catchThrowable(() -> studentDAO.save(conn, studentToUpdate));
        }

        // then
        assertThat(thrown)
            .isInstanceOf(RuntimeException.class)
            .hasMessageContaining("wrong id");
    }

    /**
     * Tests findById() method.
     */
    @Test
    void shouldNotGetStudentWhenFindByWrongId() throws Exception {
        // given
        Optional<Student> studentFound;

        // when
        try (var conn = dataSource.getConnection()) {
            initScheme(conn);
            studentFound = studentDAO.findById(conn, 10L);
        }

        // then
        assertThat(studentFound).isNotPresent();
    }

    /**
     * Tests findById() method.
     */
    @Test
    void shouldGetStudentWhenFindById() throws Exception {
        // given
        Optional<Student> studentFound;
        var sql = ResourceUtils.loadText("sql/insertStudent.sql");

        // when
        try (var conn = dataSource.getConnection()) {
            initScheme(conn);
            try (var ps = conn.prepareStatement(sql)) {
                ps.executeUpdate();
            }
            studentFound = studentDAO.findById(conn, 1L);
        }

        // then
        assertThat(studentFound).isPresent();
        assertThat(studentFound.get().getFirstName()).isEqualTo("John");
        assertThat(studentFound.get().getLastName()).isEqualTo("Doe");
    }

    /**
     * Tests findAll() method.
     */
    @Test
    void shouldFindAllWhenDBHasRecords() throws Exception {
        // given
        var sql = ResourceUtils.loadText("sql/insertStudents.sql");
        List<Student> studentsExpected = new ArrayList<>();
        Collections.addAll(studentsExpected,
            new Student(1L, "John", "Doe"),
            new Student(2L, "Alex", "Smith")
        );
        List<Student> studentsActual;

        // when
        try (var conn = dataSource.getConnection()) {
            initScheme(conn);
            try (var ps = conn.prepareStatement(sql)) {
                ps.executeUpdate();
            }
            studentsActual = studentDAO.findAll(conn);
        }

        // then
        assertThat(studentsActual.size()).isEqualTo(2);
        assertThat(studentsExpected).isEqualTo(studentsActual);
    }

    /**
     * Tests findAll() method.
     */
    @Test
    void shouldNotFindAllWhenDBHasNoRecords() throws Exception {
        // given
        List<Student> students;

        // when
        try (var conn = dataSource.getConnection()) {
            initScheme(conn);
            students = studentDAO.findAll(conn);
        }

        // then
        assertThat(students.size()).isZero();
    }

    /**
     * Tests deleteById() method.
     */
    @Test
    void shouldTestWhenDeleteById() throws Exception {
        // given
        var sql = ResourceUtils.loadText("sql/insertStudent.sql");
        boolean isRowExistedBeforeDelete;
        boolean isRowExistedsAfterDelete;

        // when
        try (var conn = dataSource.getConnection()) {
            initScheme(conn);
            try (var ps = conn.prepareStatement(sql)) {
                ps.executeUpdate();
            }
            isRowExistedBeforeDelete = isRowExisted(conn);
            studentDAO.deleteById(conn, 1L);
            isRowExistedsAfterDelete = isRowExisted(conn);
        }

        // then
        assertThat(isRowExistedBeforeDelete).isTrue();
        assertThat(isRowExistedsAfterDelete).isFalse();
    }

    /**
     * Tests deleteById() method.
     */
    @Test
    void shouldThrowExceptionWhenDeleteByWrongId() throws Exception {
        // given
        Throwable thrown = null;

        // when
        try (var conn = dataSource.getConnection()) {
            initScheme(conn);
            thrown = catchThrowable(() -> studentDAO.deleteById(conn, 10L));
        }

        // then
        assertThat(thrown)
            .isInstanceOf(RuntimeException.class)
            .hasMessageContaining("wrong id");
    }

    /**
     * Method checks if the row with ID=1 exists.
     *
     * @param conn Connection
     * @return boolean
     * @throws Exception Exception
     */
    private boolean isRowExisted(Connection conn) throws Exception {
        var sqlSelect = "select * from students where id=1;";
        try (var ps = conn.prepareStatement(sqlSelect)) {
            try (var rs = ps.executeQuery()) {
                return rs.next();
            }
        }
    }
}
