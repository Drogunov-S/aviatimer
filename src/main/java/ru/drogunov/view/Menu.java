package ru.drogunov.view;

import ru.drogunov.Application;

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
            double travelTime = application.run(path);
            if (travelTime == -1) {
                System.out.println("Неверный путь к файлу.");
                continue;
            }
            System.out.printf("Среднее время полета между городами %.0f минуты или %.0f:%.0f час%n."
                    , travelTime, travelTime / 60, travelTime % 60);
            System.out.println("Для другого расчета введите адрес к файлу.");
        }
    }
}
