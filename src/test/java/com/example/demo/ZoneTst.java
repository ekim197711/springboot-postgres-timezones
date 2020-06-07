package com.example.demo;

import org.junit.jupiter.api.Test;

import java.time.ZoneId;

public class ZoneTst {

    @Test
    public void gimmeZones(){
        for (String availableZoneId : ZoneId.getAvailableZoneIds()) {
            System.out.println(availableZoneId);
        }
    }
}
