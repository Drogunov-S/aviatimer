package ru.drogunov.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import ru.drogunov.dao.Tickets;
import ru.drogunov.entity.Ticket;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class LoaderServiceIml implements LoaderService {
    
    private final ObjectMapper mapper;
    
    public LoaderServiceIml(ObjectMapper mapper) {
        this.mapper = mapper;
    }
    
    @Override
    public List<Ticket> loadData(String path) throws IOException {
            return mapper.readValue(new File(path), Tickets.class)
                    .getTickets();
    }
}
