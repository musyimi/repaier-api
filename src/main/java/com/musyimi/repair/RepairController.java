package com.musyimi.repair;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class RepairController {

    private final RepairService repairService;

    public RepairController(RepairService repairService) {
        this.repairService = repairService;
    }

    @GetMapping(path = "api/v1/repairs")
    public List<Repair> getRepairs() {
        return repairService.getAllRepairs();
    }

    @GetMapping(path = "api/v1/repairs/{id}")
    public Repair getRepair(@PathVariable("id") Integer id) {
        return repairService.getRepair(id);
    }
}
