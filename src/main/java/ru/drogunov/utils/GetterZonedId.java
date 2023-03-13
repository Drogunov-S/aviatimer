package ru.drogunov.utils;

import lombok.experimental.UtilityClass;

import java.time.ZoneId;
import java.util.HashMap;
import java.util.Map;

@UtilityClass
public class GetterZonedId {
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
    
    
}
