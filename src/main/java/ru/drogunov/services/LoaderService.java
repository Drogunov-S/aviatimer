package ru.drogunov.services;

import ru.drogunov.entity.Ticket;

import java.io.IOException;
import java.util.List;

public interface LoaderService {
    List<Ticket> loadData(String path) throws IOException;
}
