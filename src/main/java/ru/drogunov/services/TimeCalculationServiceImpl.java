package ru.drogunov.services;

import ru.drogunov.entity.Ticket;

import java.time.Duration;
import java.util.List;

public class TimeCalculationServiceImpl implements TimeCalculationService {
    @Override
    public double getTravelTime(List<Ticket> ticketList) {
        long sum = ticketList.stream()
                .map(ticket -> Duration.between(ticket.getDepartureDate(), ticket.getArrivalDate()).toMinutes())
                .mapToLong(Long::longValue).sum();
        return (double) sum / ticketList.size();
    }
}
