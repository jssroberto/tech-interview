package com.mediaaerea.backend.controller;

import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.mediaaerea.backend.api.request.TicketRequest;
import com.mediaaerea.backend.api.response.TicketResponse;
import com.mediaaerea.backend.service.TicketService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/v1/tickets")
@RequiredArgsConstructor
public class TicketController {

    private final TicketService ticketService;

    @GetMapping()
    private List<TicketResponse> getAllTickets() {
        return ticketService.getAllTickets();
    }

    @PostMapping()
    public TicketResponse createTicket(@Valid @RequestBody TicketRequest ticketRequest) {
        return ticketService.createTicket(ticketRequest);
    }

}
