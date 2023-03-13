package ru.drogunov.view;

import ru.drogunov.Application;

public class Console implements View {
    @Override
    public void run(String pathToJson) {
        Application application = new Application();
        double travelTime = application.run(pathToJson);
        if (travelTime == -1) {
            System.out.println("Неверный путь к файлу.");
        } else {
            System.out.printf("Среднее время полета между городами %.0f минуты или %.0f:%.0f час."
                    , travelTime, travelTime / 60, travelTime % 60);
        }
    }
}
