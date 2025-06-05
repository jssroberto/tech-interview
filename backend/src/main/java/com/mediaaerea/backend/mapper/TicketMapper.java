package com.mediaaerea.backend.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import com.mediaaerea.backend.api.request.TicketRequest;
import com.mediaaerea.backend.api.response.TicketResponse;
import com.mediaaerea.backend.model.Ticket;

@Mapper(componentModel = "spring")
public interface TicketMapper {

    @Mapping(target = "id", ignore = true)
    Ticket toEntity(TicketRequest ticketRequest);

    TicketResponse toResponse(Ticket ticket);

}
