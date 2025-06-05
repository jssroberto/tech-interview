package com.mediaaerea.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.mediaaerea.backend.model.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Long> {

}
