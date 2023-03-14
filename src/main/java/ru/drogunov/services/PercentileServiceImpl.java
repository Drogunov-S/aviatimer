package ru.drogunov.services;

import java.util.ArrayList;
import java.util.List;

public class PercentileServiceImpl implements PercentileService {
    //Можно было при помощи, библиотеки Apace Common
    @Override
    public double getPercentile(List<Long> arrayNumbers, double average, int percentile) {
        int index = (int) Math.ceil(((double) percentile / (double) 100) * (double) arrayNumbers.size());
        return arrayNumbers.get(index - 1);
    }
}
