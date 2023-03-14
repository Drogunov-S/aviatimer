package ru.drogunov.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import ru.drogunov.utils.TimeUtil;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZonedDateTime;

@Getter
@Setter
@ToString
public class Ticket {
    private String origin;
    @JsonProperty("origin_name")
    private String originName;
    private String destination;
    @JsonProperty("destination_name")
    private String destinationName;
    @JsonProperty("departure_date")
    @JsonFormat(pattern = "dd.MM.yy")
    private LocalDate departureDate;
    @JsonProperty("departure_time")
    @JsonFormat(pattern = "H:mm")
    private LocalTime departureTime;
    @JsonProperty("arrival_date")
    @JsonFormat(pattern = "dd.MM.yy")
    private LocalDate arrivalDate;
    @JsonProperty("arrival_time")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
    private LocalTime arrivalTime;
    private String carrier;
    private int stops;
    private int price;
    
    public ZonedDateTime getDepartureDate() {
        return ZonedDateTime.of(
                departureDate,
                departureTime,
                TimeUtil.getZoneId(destinationName)
        );
    }
    
    public ZonedDateTime getArrivalDate() {
        return ZonedDateTime.of(
                arrivalDate,
                arrivalTime,
                TimeUtil.getZoneId(destinationName)
        );
    }
}
