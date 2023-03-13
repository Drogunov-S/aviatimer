package ru.drogunov.services;

import ru.drogunov.entity.Ticket;

import java.util.List;

public interface TimeCalculationService {
    double getTravelTime(List<Ticket> ticketList);
}
