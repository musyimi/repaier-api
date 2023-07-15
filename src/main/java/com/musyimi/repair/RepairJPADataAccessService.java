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
    public boolean existsPersonWithPhoneNumber(Integer phoneNumber) {
        return repairRepository.existsRepairByPhoneNumber(phoneNumber);

    }

    @Override
    public boolean existsRepairWithId(Integer id) {
        return repairRepository.existsRepairById(id);
    }

    @Override
    public void deleteById(Integer id) {
        repairRepository.deleteById(id);
    }

    @Override
    public void updateRepair(Repair update) {
        repairRepository.save(update);
    }

    @Override
    public Optional<Repair> selectRepairById(Integer id) {
        return repairRepository.findById(id);
    }



}
