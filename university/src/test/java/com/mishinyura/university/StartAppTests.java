package com.mishinyura.university;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ActiveProfiles;

import java.util.HashSet;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Class StartAppTests.
 * Tests com.mishinyura.university.StartApp class.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 24.08.2021
 */
@SpringBootTest
@ActiveProfiles("test")
class StartAppTests {
    /**
     * JdbcTemplate.
     */
    @Autowired
    JdbcTemplate template;

    /**
     * Tests DB Schema.
     */
    @Test
    void shouldCheckMigrationDone() {
        // given
        var query = "show tables";
        var sizeExpected = 1;
        var tablesActual = new HashSet<>();
        var tablesExpected = List.of(
            "SUBJECTS"
        );

        // when
        var rs = template.queryForRowSet(query);
        while (rs.next()) {
            tablesActual.add(rs.getString("TABLE_NAME"));
        }
        tablesActual.remove("flyway_schema_history");

        // then
        assertThat(tablesActual.size()).isEqualTo(sizeExpected);
        assertThat(tablesActual).containsAll(tablesExpected);
    }
}
