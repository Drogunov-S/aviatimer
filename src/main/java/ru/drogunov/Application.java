package ru.drogunov;

import com.fasterxml.jackson.databind.ObjectMapper;
import ru.drogunov.services.LoaderServiceIml;
import ru.drogunov.services.TimeCalculationService;
import ru.drogunov.services.TimeCalculationServiceImpl;

import java.io.IOException;

public class Application {
    public double run(String pathToJson) {
        ObjectMapper mapper = new ObjectMapper().findAndRegisterModules();
        LoaderServiceIml loaderService = new LoaderServiceIml(mapper);
        TimeCalculationService timeCalculationService = new TimeCalculationServiceImpl();
        try {
            return timeCalculationService.getTravelTime(loaderService.loadData(pathToJson));
        } catch (IOException e) {
            return -1;
            //Сделал специально)
        }
    }
}
