package seeder;


import com.github.javafaker.Faker;
import dao.impl.StudentDAOImpl;
import model.Student;

import java.sql.Connection;
import java.util.stream.Stream;

/**
 * Class StudentGenerator.
 * Implements StudentGenerator.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 18.08.2021
 */
public class StudentGenerator {
    /**
     * StudentDAO.
     */
    private static final StudentDAOImpl DAO = new StudentDAOImpl();
    /**
     * Faker.
     */
    private static final Faker FAKER = new Faker();


    /**
     * Method generates data.
     *
     * @param conn   Connection
     * @param number Number
     */
    public static void generateData(final Connection conn, final int number) {
        Stream.generate(
            () -> new Student(
                FAKER.name().firstName(), FAKER.name().lastName())
        )
            .limit(number)
            .forEach(student -> DAO.save(conn, student));
    }
}
