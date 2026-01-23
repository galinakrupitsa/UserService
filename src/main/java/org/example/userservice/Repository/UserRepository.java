package org.example.userservice.Repository;

import org.example.userservice.Model.Users;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {
    private final JdbcTemplate jdbcTemplate;
    public UserRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    public Users findById(Long id) {
        String sql = "SELECT id, first_name, second_name FROM users WHERE id = ?";

        return jdbcTemplate.queryForObject(
                sql,
                new Object[]{id},
                (rs, rowNum) -> new Users(
                        rs.getLong("id"),
                        rs.getString("first_name"),
                        rs.getString("second_name")
                )
        );
    }

    public Users create(String firstName, String secondName) {
        String sql = """
        INSERT INTO users (first_name, second_name)
        VALUES (?, ?)
        RETURNING id
        """;

        Long id = jdbcTemplate.queryForObject(
                sql,
                new Object[]{firstName, secondName},
                Long.class
        );

        return new Users(id, firstName, secondName);
    }

}
