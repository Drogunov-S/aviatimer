package ru.drogunov.entity;

public final class Result {
    
    private final double averageFlightTimeMinutes;
    
    private final double percentile;
    
    public Result(double averageFlightTimeMinutes, double percentile) {
        this.averageFlightTimeMinutes = averageFlightTimeMinutes;
        this.percentile = percentile;
    }
    
    public double getAverageFlightTimeMinutes() {
        return averageFlightTimeMinutes;
    }
    
    public double getPercentile() {
        return percentile;
    }
}
