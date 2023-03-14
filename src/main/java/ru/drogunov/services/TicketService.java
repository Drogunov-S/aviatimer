package ru.drogunov.services;

import ru.drogunov.entity.Ticket;

import java.time.Duration;
import java.util.List;

public class TicketService {
    public List<Duration> getTravelTime(List<Ticket> ticketList) {
        return ticketList.stream()
                .map(ticket -> Duration.between(ticket.getDepartureDate(), ticket.getArrivalDate()))
                .toList();
    }
}
