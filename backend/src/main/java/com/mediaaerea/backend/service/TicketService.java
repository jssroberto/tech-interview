package com.mediaaerea.backend.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.mediaaerea.backend.api.request.TicketRequest;
import com.mediaaerea.backend.api.response.TicketResponse;
import com.mediaaerea.backend.mapper.TicketMapper;
import com.mediaaerea.backend.model.Ticket;
import com.mediaaerea.backend.repository.TicketRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
@Service
public class TicketService {

    private final TicketRepository ticketRepository;
    private final TicketMapper ticketMapper;

    @Transactional
    public TicketResponse createTicket(TicketRequest ticketRequest) {
        Ticket ticket = ticketMapper.toEntity(ticketRequest);
        Ticket savedTicket = ticketRepository.save(ticket);
        return ticketMapper.toResponse(savedTicket);
    }

    @Transactional(readOnly = true)
    public List<TicketResponse> getAllTickets() {

        List<Ticket> tickets = ticketRepository.findAll();
        List<TicketResponse> responses = new ArrayList<>();
        for (Ticket ticket : tickets) {
            responses.add(ticketMapper.toResponse(ticket));
        }
        return responses;
    }

}
