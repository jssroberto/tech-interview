package com.mediaaerea.backend.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.mediaaerea.backend.api.request.TicketRequest;
import com.mediaaerea.backend.api.response.TicketResponse;
import com.mediaaerea.backend.service.TicketService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/tickets")
@RequiredArgsConstructor
public class TicketController {

    private final TicketService ticketService;

    @GetMapping("/all")
    private List<TicketResponse> getAllTickets() {
        return ticketService.getAllTickets();
    }

    @PostMapping("/create")
    public TicketResponse createTicket(@RequestBody TicketRequest ticketRequest) {
        return ticketService.createTicket(ticketRequest);
    }

}
