package com.musyimi.repair;

import com.musyimi.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RepairService {

    private final RepairDao repairDao;

    public RepairService(@Qualifier("jpa") RepairDao repairDao) {
        this.repairDao = repairDao;
    }

    public List<Repair> getAllRepairs() {
        return repairDao.selectAllRepairs();
    }

    public Repair getRepair(Integer id) {
        return repairDao.selectRepairById(id)
                .orElseThrow(
                        () -> new ResourceNotFoundException("customer with id [%s] is not found ".formatted(id))
                );
    }
}
