package model;

import java.util.Objects;

/**
 * Class Student.
 * Implements Student.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 17.08.2021
 */
public class Student {
    /**
     * ID.
     */
    private Long id;
    /**
     * First name.
     */
    private String firstName;
    /**
     * Last name.
     */
    private String lastName;

    /**
     * Constructor.
     *
     * @param firstName First name
     * @param lastName  Last name
     */
    public Student(final String firstName, final String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    /**
     * Constructor.
     *
     * @param id        Id
     * @param firstName First name
     * @param lastName  Last name
     */
    public Student(
        final Long id,
        final String firstName,
        final String lastName) {

        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    /**
     * @return ID
     */
    public Long getId() {
        return id;
    }

    /**
     * @return First name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @return Last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param o Object
     * @return boolean
     */
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        var student = (Student) o;
        return id.equals(student.id)
            && firstName.equals(student.firstName)
            && lastName.equals(student.lastName);
    }

    /**
     * @return int
     */
    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName);
    }
}
