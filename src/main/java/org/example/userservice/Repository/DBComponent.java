package org.example.userservice.Repository;

import jakarta.annotation.PostConstruct;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class DBComponent {

        private final JdbcTemplate jdbcTemplate;

        public DBComponent(JdbcTemplate jdbcTemplate) {
            this.jdbcTemplate = jdbcTemplate;
        }

    @PostConstruct
        public void checkConnection() {
            Integer result = jdbcTemplate.queryForObject(
                    "SELECT 1",
                    Integer.class
            );
            System.out.println("JDBC CONNECTION OK, RESULT = " + result);
        }
    }


