package ru.drogunov.services;

import java.time.Duration;
import java.util.List;

public interface PercentileService {
    double getPercentile(List<Long> arrayNumbers, double average, int percentile);
}
