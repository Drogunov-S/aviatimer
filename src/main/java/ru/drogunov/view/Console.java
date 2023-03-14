package ru.drogunov.view;

import ru.drogunov.Application;
import ru.drogunov.entity.Result;
import ru.drogunov.utils.TimeUtil;

import java.time.temporal.ChronoUnit;
import java.util.Objects;

public class Console implements View {
    @Override
    public void run(String pathToJson) {
        Application application = new Application();
        Result result = application.run(pathToJson);
        if (Objects.isNull(result)) {
            System.out.println("Неверный путь к файлу.");
        } else {
            double averageFlightTime = result.getAverageFlightTimeMinutes();
            double percentile = result.getPercentile();
    
            System.out.printf("Среднее время полета между городами %.0f минуты или %s час%n.",
                    averageFlightTime ,TimeUtil.getTime(averageFlightTime, ChronoUnit.MINUTES));
            System.out.printf("90-й процентиль: %.0f минут. Или %s чaс:%n",
                    percentile, TimeUtil.getTime(percentile, ChronoUnit.MINUTES));
        }
    }
}
