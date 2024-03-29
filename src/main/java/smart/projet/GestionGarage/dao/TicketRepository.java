package smart.projet.GestionGarage.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import smart.projet.GestionGarage.entity.Admin;
import smart.projet.GestionGarage.entity.Ticket;
import java.util.List;
@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {

    public List<Ticket> findByAdmin(Admin admin);
}