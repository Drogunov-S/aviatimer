package ru.drogunov.dao;

import lombok.ToString;
import ru.drogunov.entity.Ticket;

import java.util.List;

@ToString
public class Tickets {
    
    private List<Ticket> tickets;
    
    public List<Ticket> getTickets() {
        return tickets;
    }
    
    
}
