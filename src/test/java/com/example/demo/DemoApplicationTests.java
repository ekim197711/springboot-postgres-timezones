package com.example.demo;

import com.example.demo.model.SpaceShipMessage;
import com.example.demo.model.SpaceShipMessgeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {

    @Autowired
    SpaceShipMessgeRepository spaceShipMessgeRepository;

    @Test
    public void contextLoads() {
        for (SpaceShipMessage spaceShipMessage : spaceShipMessgeRepository.findAll()) {
            System.out.println(spaceShipMessage);
        }
    }

}
