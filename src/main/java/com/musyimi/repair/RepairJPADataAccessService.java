package com.musyimi.repair;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository("jpa")
public class RepairJPADataAccessService implements RepairDao{

    private final RepairRepository repairRepository;

    public RepairJPADataAccessService(RepairRepository repairRepository) {
        this.repairRepository = repairRepository;
    }

    @Override
    public List<Repair> selectAllRepairs() {
        return repairRepository.findAll();
    }

    @Override
    public Optional<Repair> selectRepairById(Integer id) {
        return Optional.empty();
    }
}
