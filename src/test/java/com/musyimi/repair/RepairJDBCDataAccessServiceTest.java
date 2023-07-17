package com.musyimi.repair;

import com.musyimi.AbstractTestcontainersUnitTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import static org.junit.jupiter.api.Assertions.*;

class RepairJDBCDataAccessServiceTest extends AbstractTestcontainersUnitTest {

    private RepairJDBCDataAccessService underTest;
    private final RepairRowMapper repairRowMapper = new RepairRowMapper();

    @BeforeEach
    void setUp() {
        underTest = new RepairJDBCDataAccessService(
                getJdbcTemplate(),
                repairRowMapper
        );
    }

    @Test
    void selectAllRepairs() {
    }

    @Test
    void selectRepairById() {
    }

    @Test
    void insertRepair() {
    }

    @Test
    void existsPersonWithPhoneNumber() {
    }

    @Test
    void existsRepairWithId() {
    }

    @Test
    void deleteById() {
    }

    @Test
    void updateRepair() {
    }
}