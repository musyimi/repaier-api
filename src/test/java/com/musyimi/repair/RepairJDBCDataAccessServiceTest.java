package com.musyimi.repair;

import com.musyimi.AbstractTestcontainersUnitTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
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
        Repair repair = new Repair(
                FAKER.name().fullName(),
                FAKER.name().title(),
                FAKER.company().name(),
                FAKER.book().publisher(),
                FAKER.hashCode()
        );
        underTest.insertRepair(repair);

        List<Repair> repairs = underTest.selectAllRepairs();

        assertThat(repairs).isNotEmpty();

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