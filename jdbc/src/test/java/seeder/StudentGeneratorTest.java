package seeder;

import dao.impl.StudentDAOImpl;
import data.H2DataSource;
import model.Student;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.TestUtils;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Class StudentGeneratorTest.
 * Tests seeder.StudentGenerator class.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 18.08.2021
 */
class StudentGeneratorTest {
    /**
     * H2DataSource.
     */
    private static H2DataSource dataSource;

    /**
     * Student DAO.
     */
    private static StudentDAOImpl studentDAO;

    @BeforeEach
    void setup() {
        var props = TestUtils.loadPropsFromResources("db.properties");
        dataSource = new H2DataSource(props);
        studentDAO = new StudentDAOImpl();
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
     * Tests generateData() method.
     */
    @Test
    void shouldGenerateStudents() throws Exception {
        // given
        var sizeExpected = 5;
        var sizeActual = 0;
        List<Student> students;
        Optional<Student> student;

        // when
        try (var conn = dataSource.getConnection()) {
            initScheme(conn);
            StudentGenerator.generateData(conn, sizeExpected);
            students = studentDAO.findAll(conn);
            sizeActual = students.size();
            student = studentDAO.findById(conn, 1L);
        }

        // then
        assertThat(students).isInstanceOf(ArrayList.class);
        assertThat(sizeActual).isEqualTo(sizeExpected);
        assertThat(student).isPresent();
        assertThat(student.get().getId()).isEqualTo(1L);
        assertThat(student.get().getFirstName()).isInstanceOf(String.class);
        assertThat(student.get().getLastName()).isInstanceOf(String.class);
    }
}