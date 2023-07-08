package com.musyimi.repair;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RepairRepository extends JpaRepository<Repair, Integer> {

   boolean existsRepairByPhoneNumber(Integer phone_number);
}
