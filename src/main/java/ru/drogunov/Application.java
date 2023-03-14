package ru.drogunov;

import com.fasterxml.jackson.databind.ObjectMapper;
import ru.drogunov.entity.Result;
import ru.drogunov.entity.Ticket;
import ru.drogunov.services.*;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class Application {
    public Result run(String pathToJson) {
        //Можно добавить в параметры и будет расчет произвольный
        int percentile = 90;
        
        ObjectMapper mapper = new ObjectMapper().findAndRegisterModules();
        LoaderServiceIml loaderService = new LoaderServiceIml(mapper);
        TicketService ticketService = new TicketService();
        TimeCalculationService timeCalculationService = new TimeCalculationServiceImpl(ticketService);
        PercentileService percentileService = new PercentileServiceImpl();
        
        try {
            List<Ticket> ticketList = loaderService.loadData(pathToJson);
            List<Long> travelTimeList = ticketService.getTravelTime(ticketList)
                    .stream()
                    .map(Duration::toMinutes)
                    .sorted()
                    .toList();
            double averageTravelTime = timeCalculationService.getTravelTime(ticketList);
            
            double findPercentile = percentileService.getPercentile(travelTimeList, averageTravelTime, percentile);
            return new Result(averageTravelTime, findPercentile);
        } catch (IOException e) {
            return null;
            //Сделал специально)
        }
    }
}
