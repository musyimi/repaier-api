package com.musyimi.repair;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class RepairDataAccessService implements RepairDao{
    private static List<Repair> repairs;

    static {
        repairs = new ArrayList<>();
        Repair phone = new Repair(
                1,
                "Mucomba",
                "Nokia 3310",
                "Nokia",
                "The phone is not charging",
                0722000000
        );
        repairs.add(phone);

        Repair laptop = new Repair(
                2,
                "Ruger",
                "Lenovo 500",
                "Lenovo",
                "The Screen is broken",
                0722111111
        );
        repairs.add(laptop);
    }

    @Override
    public List<Repair> selectAllRepairs() {
        return repairs;
    }

    @Override
    public void insertRepair(Repair repair) {
         repairs.add(repair);
    }

    @Override
    public boolean existsPersonWithPhoneNumber(Integer phoneNumber) {
        return repairs.stream()
                .anyMatch(c -> c.getphoneNumber().equals(phoneNumber));
    }

    @Override
    public boolean existsRepairWithId(Integer id) {
        return repairs.stream()
                .anyMatch(c -> c.getId().equals(id));
    }

    @Override
    public void deleteById(Integer id) {
        repairs.stream()
                .filter(c -> c.getId().equals(id))
                .findFirst()
                .ifPresent(repairs::remove);
    }

    @Override
    public Optional<Repair> selectRepairById(Integer id) {
        return repairs.stream()
                .filter(c -> c.getId().equals(id))
                .findFirst();

    }

    @Override
    public void updateRepair(Repair repair) {
        repairs.add(repair);
    }
}
