package com.musyimi.repair;

import com.musyimi.exception.ResourceNotFoundException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class RepairServiceTest {

    @Mock
    private RepairDao repairDao;
    private RepairService underTest;

    @BeforeEach
    void setUp() {
        underTest = new RepairService(repairDao);
    }

    @Test
    void getAllRepairs() {
        underTest.getAllRepairs();
        verify(repairDao).selectAllRepairs();
    }

    @Test
    void canGetRepair() {
        int id = 1;

        Repair repair = new Repair("Kamau", "Nikia 3300", "Nokia", "Charging port", 800565222);
        when(repairDao.selectRepairById(id))
                .thenReturn(Optional.of(repair));

        Repair actual = underTest.getRepair(1);

        assertThat(actual).isEqualTo(repair);
    }

    @Test
    void willThrowWhenRepairReturnEmptyOptional() {
        int id = 1;

        when(repairDao.selectRepairById(id))
                .thenReturn(Optional.empty());

        assertThatThrownBy(() -> underTest.getRepair(id))
                .isInstanceOf(ResourceNotFoundException.class)
                .hasMessage("Repair with id [%s] is not found".formatted(id));
    }

    @Test
    void addRepair() {
    }

    @Test
    void deleteById() {
    }

    @Test
    void updateRepair() {
    }
}