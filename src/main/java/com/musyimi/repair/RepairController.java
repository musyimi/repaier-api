package com.musyimi.repair;

import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/v1/repairs")
public class RepairController {

    private final RepairService repairService;

    public RepairController(RepairService repairService) {
        this.repairService = repairService;
    }

    @GetMapping
    public List<Repair> getRepairs() {
        return repairService.getAllRepairs();
    }

    @GetMapping("{id}")
    public Repair getRepair(@PathVariable("id") Integer id) {
        return repairService.getRepair(id);
    }


    @PostMapping
    public void registerRepair(
            @RequestBody RepairRegistrationRequest request) {
        repairService.addRepair(request);
    }
}
