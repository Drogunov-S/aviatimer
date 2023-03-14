package ru.drogunov.view;

import ru.drogunov.Application;
import ru.drogunov.entity.Result;
import ru.drogunov.utils.TimeUtil;

import java.time.temporal.ChronoUnit;
import java.util.Objects;
import java.util.Scanner;

public class Menu implements View {
    @Override
    public void run(String path) {
        System.out.println("Введите полный путь к файлу: ");
        System.out.println("Для закрытия введите 0: ");
        Scanner br = new Scanner(System.in);
        Application application = new Application();
        //Валидацию не делал.
        while (Objects.isNull(path) || !Objects.equals(path, "0")) {
            path = br.nextLine();
            Result result = application.run(path);
            if (Objects.isNull(result)) {
                System.out.println("Неверный путь к файлу.");
                continue;
            }
            double averageFlightTime = result.getAverageFlightTimeMinutes();
            double percentile = result.getPercentile();
            System.out.printf("Среднее время полета между городами %.0f минуты или %s час%n.",
                    averageFlightTime, TimeUtil.getTime(averageFlightTime, ChronoUnit.MINUTES));
            System.out.printf("90-й процентиль: %.0f минут. Или %s чaс:%n",
                    percentile, TimeUtil.getTime(percentile, ChronoUnit.MINUTES));
            System.out.println("Для другого расчета введите адрес к файлу.");
        }
    }
}
