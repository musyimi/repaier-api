package com.musyimi.repair;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository("jdbc")
public class RepairJDBCDataAccessService implements RepairDao{

    private final JdbcTemplate jdbcTemplate;

    public RepairJDBCDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public List<Repair> selectAllRepairs() {
        var sql = """
                SELECT id, name, title, issue, brand, phone_number
                FROM repair
                """;
        RowMapper<Repair> repairRowMapper = (rs, rowNum) -> {
            Repair repair = new Repair(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("title"),
                    rs.getString("issue"),
                    rs.getString("brand"),
                    rs.getInt("phone_number")
            );
            return repair;
        };
        List<Repair> repairs = jdbcTemplate.query(sql, repairRowMapper);
        return repairs;
    }

    @Override
    public Optional<Repair> selectRepairById(Integer id) {
        return Optional.empty();
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
