package com.example.demo.model;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

@Component
@RequiredArgsConstructor
public class InitData {
    private final SpaceShipMessgeRepository spaceShipMessgeRepository;

    @PostConstruct
    public void postConstruct() {
        spaceShipMessgeRepository.deleteAll();
        spaceShipMessgeRepository.save(new SpaceShipMessage(null, "test123",
                ZonedDateTime.of(LocalDateTime.now().minusDays(4), ZoneId.of("US/Arizona"))));
        spaceShipMessgeRepository.save(new SpaceShipMessage(null, "test456",
                ZonedDateTime.of(LocalDateTime.now().minusDays(4), ZoneId.of("Turkey"))));
        spaceShipMessgeRepository.save(new SpaceShipMessage(null, "test789",
                ZonedDateTime.of(LocalDateTime.now().minusDays(4), ZoneId.of("Europe/Copenhagen"))));
    }

}
