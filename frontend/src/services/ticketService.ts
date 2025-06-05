import axios from "axios";
import type { TicketResponse, TicketRequest } from "../types/ticket";

const API_URL = "http://localhost:8080/api/v1/tickets";

export const TicketService = {
  async getAllTickets(): Promise<TicketResponse[]> {
    try {
    const response = await axios.get<TicketResponse[]>(`${API_URL}`);
      return response.data;
    } catch (error) {
      console.error("Error al obtener tickets:", error);
      return [];
    }
  },
  
  async createTicket(ticket: TicketRequest): Promise<TicketResponse | null> {
    console.log("Creating ticket:", ticket);
    try {
      const response = await axios.post<TicketResponse>(API_URL, ticket);
      return response.data;
    } catch (error) {
      console.error("Error al crear el ticket", error);
      return null;
    }
  },
};
