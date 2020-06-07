package com.example.demo.api;

import com.example.demo.model.SpaceShipMessage;
import com.example.demo.model.SpaceShipMessgeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.ZoneId;
import java.time.format.DateTimeParseException;
import java.time.zone.ZoneRulesException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class SpaceshipMessageRestController {
    private final SpaceShipMessgeRepository spaceShipMessgeRepository;
    @PostMapping("/api/message")
    public String createMessage(@RequestBody SpaceShipMessageApi message){
        try{
            spaceShipMessgeRepository.save(message.mapToEntity());
        }
        catch (ZoneRulesException zre){
            return "Time zone not recognized " + zre.getLocalizedMessage();
        }
        catch (DateTimeParseException dtpe){
            return "Date time parse error " + dtpe.getLocalizedMessage();
        }
        return "The message was saved!";
    }

    @GetMapping("/api/message")
    public List<SpaceShipMessageApi> getMessages(@RequestParam String timezone){
        ZoneId zone = ZoneId.of(timezone);
        List<SpaceShipMessageApi> apiList = new ArrayList<>();
        spaceShipMessgeRepository.findAll().forEach(
                s -> apiList.add(SpaceShipMessageApi.fromEntity(s, zone))
        );
        return apiList;
    }
    }
