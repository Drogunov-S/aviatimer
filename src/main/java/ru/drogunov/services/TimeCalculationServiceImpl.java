package ru.drogunov.services;

import ru.drogunov.entity.Ticket;

import java.time.Duration;
import java.util.List;

public class TimeCalculationServiceImpl implements TimeCalculationService {
    private final TicketService ticketService;
    
    public TimeCalculationServiceImpl(TicketService ticketService) {
        this.ticketService = ticketService;
    }
    
    @Override
    public double getTravelTime(List<Ticket> ticketList) {
        long sum = ticketService.getTravelTime(ticketList)
                .stream()
                .map(Duration::toMinutes)
                .mapToLong(Long::longValue)
                .sum();
        return (double) sum / ticketList.size();
    }
}
