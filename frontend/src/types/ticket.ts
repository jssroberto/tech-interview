export interface TicketResponse {
  id: number;
  proveedor: string;
  incidente: string;
}

export interface TicketRequest {
  proveedor: string;
  incidente: string;
}
