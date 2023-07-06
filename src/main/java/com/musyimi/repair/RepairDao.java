package com.musyimi.repair;

import java.util.List;
import java.util.Optional;

public interface RepairDao {
    List<Repair> selectAllRepairs();
    Optional<Repair> selectRepairById(Integer id);
}
