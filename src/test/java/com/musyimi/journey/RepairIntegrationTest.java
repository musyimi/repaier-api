package com.musyimi.journey;

import com.musyimi.repair.Repair;
import com.musyimi.repair.RepairRegistrationRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RepairIntegrationTest {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void canRegisterRepair() {

        RepairRegistrationRequest request = new RepairRegistrationRequest(
                "Lady",
                "Gaga",
                "Used",
                "Not",
                400455912
        );

        webTestClient.post()
                .uri("/api/v1/repairs")
                .accept(MediaType.APPLICATION_JSON)
                .body(Mono.just(request), RepairRegistrationRequest.class)
                .exchange()
                .expectStatus()
                .isOk();

        List<Repair> allRepairs = webTestClient.get()
                .uri("/api/v1/repairs")
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus()
                .isOk()
                .expectBodyList(new ParameterizedTypeReference<Repair>() {
                })
                .returnResult()
                .getResponseBody();

        Repair expectedRepair = new Repair(
                "Lord",
                "Bender",
                "Used",
                "Fit",
                500455912

        );

        assertThat(allRepairs)
                .usingRecursiveFieldByFieldElementComparatorIgnoringFields("id")
                .contains(expectedRepair);

        int id = allRepairs.stream()
                        .filter(repair -> repair.getphoneNumber().equals(request.phoneNumber()))
                        .map(Repair::getId)
                        .findFirst()
                        .orElseThrow();

        expectedRepair.setId(id);

        webTestClient.get()
                .uri("/api/v1/repairs/{id}", id)
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus()
                .isOk()
                .expectBody(new ParameterizedTypeReference<Repair>() {})
                .isEqualTo(expectedRepair);
    }




    }



