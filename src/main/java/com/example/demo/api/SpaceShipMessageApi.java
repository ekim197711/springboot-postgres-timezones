package com.example.demo.api;

import com.example.demo.model.SpaceShipMessage;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.zone.ZoneRulesException;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SpaceShipMessageApi {
    private String message;
    private String datetime;
    private String timezone;

    private static DateTimeFormatter DATETIMEFORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    public SpaceShipMessage mapToEntity() throws ZoneRulesException, DateTimeParseException {
        LocalDateTime ldt = LocalDateTime.parse(datetime,DATETIMEFORMATTER);
        ZonedDateTime zdt = ZonedDateTime.of(ldt, ZoneId.of(timezone));
        return new SpaceShipMessage(null, message, zdt);
    }

    public static SpaceShipMessageApi fromEntity(SpaceShipMessage spaceShipMessage, ZoneId zone){
        LocalDateTime localDateTime = spaceShipMessage.getDateTime().withZoneSameInstant(zone).toLocalDateTime();
        SpaceShipMessageApi messageApi = new SpaceShipMessageApi(
                spaceShipMessage.getMessage(),
                localDateTime.format(DATETIMEFORMATTER),zone.toString()
        );
        return messageApi;
    }


}
