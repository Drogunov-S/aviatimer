package ru.drogunov.utils;

import lombok.experimental.UtilityClass;

import java.time.ZoneId;
import java.time.temporal.TemporalUnit;
import java.util.HashMap;
import java.util.Map;
import java.time.Duration;
import java.util.logging.SimpleFormatter;

@UtilityClass
public class TimeUtil {
    private final Map<String, String> ruJavaZoneId = new HashMap<>();
    
    /*
     * Это будет либо загружаться с файла или из БД.
     * */
    static {
        ruJavaZoneId.put("Владивосток", "Asia/Vladivostok");
        ruJavaZoneId.put("Тель-Авив", "Asia/Tel_Aviv");
    }
    
    public ZoneId getZoneId(String cityName) {
        return ZoneId.of(ruJavaZoneId.get(cityName));
    }
    
    
    public String getTime(double time, TemporalUnit temporalUnit) {
        Duration duration = Duration.of((long) time, temporalUnit);
        return String.format("%02d:%02d", duration.toHours(), duration.toMinutesPart());
    }
    
}
