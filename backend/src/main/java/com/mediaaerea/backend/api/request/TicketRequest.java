package com.mediaaerea.backend.api.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TicketRequest {

    @NotBlank(message = "El proveedor no puede estar vacío")
    private String proveedor;

    @NotBlank(message = "El incidente no puede estar vacío")
    private String incidente;

}
