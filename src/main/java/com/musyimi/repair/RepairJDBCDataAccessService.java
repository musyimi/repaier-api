package com.musyimi.repair;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository("jdbc")
public class RepairJDBCDataAccessService implements RepairDao{

    private final JdbcTemplate jdbcTemplate;
    private final RepairRowMapper repairRowMapper;

    public RepairJDBCDataAccessService(JdbcTemplate jdbcTemplate, RepairRowMapper repairRowMapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.repairRowMapper = repairRowMapper;
    }


    @Override
    public List<Repair> selectAllRepairs() {
        var sql = """
                SELECT id, name, title, issue, brand, phone_number
                FROM repair
                """;

        return jdbcTemplate.query(sql, repairRowMapper);

    }

    @Override
    public Optional<Repair> selectRepairById(Integer id) {
        var sql = """
                SELECT id, name, title, issue, brand, phone_number
                FROM repair
                WHERE id = ?
                """;
        return jdbcTemplate.query(sql, repairRowMapper, id)
                .stream()
                .findFirst();
    }

    @Override
    public void insertRepair(Repair repair) {
         var sql = """
                 INSERT INTO repair(name, title, brand, issue, phone_number)
                 VALUES (?, ?, ?, ?, ?)
                 """;
         jdbcTemplate.update(
                 sql,
                 repair.getBrand(),
                 repair.getIssue(),
                 repair.getTitle(),
                 repair.getName(),
                 repair.getphoneNumber()
         );
    }

    @Override
    public boolean existsPersonWithPhoneNumber(Integer phoneNumber) {
        return false;
    }

    @Override
    public boolean existsRepairWithId(Integer id) {
        return false;
    }

    @Override
    public void deleteById(Integer id) {

    }

    @Override
    public void updateRepair(Repair update) {

    }
}
