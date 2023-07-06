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
    public void insertRepair(Repair repair) {
        repairRepository.save(repair);
    }


    @Override
    public Optional<Repair> selectRepairById(Integer id) {
        return repairRepository.findById(id);
    }

    @Override
    public boolean existsPersonWithPhoneNumber(Integer phone_number) {
       return repairRepository.existsPersonWithPhoneNumber(phone_number);
    }
}
