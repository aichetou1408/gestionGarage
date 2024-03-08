package smart.projet.GestionGarage.service;

import java.util.List;
import org.springframework.stereotype.Service;

import smart.projet.GestionGarage.entity.Ticket;

@Service

public interface TicketService {

    public List<Ticket> findAll();

    public Ticket create(Ticket ticket);

    public Boolean delete(Long id);
}
    