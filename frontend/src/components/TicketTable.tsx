import { useEffect, useState } from "react";
import { TicketService } from "../services/ticketService";
import type { TicketResponse } from "../types/ticket";
import "./TicketTable.css";

export function TicketTable() {
  const [tickets, setTickets] = useState<TicketResponse[]>([]);
  const [isModalOpen, setIsModalOpen] = useState(false);
  const [proveedor, setProveedor] = useState("");
  const [incidente, setIncidente] = useState("");

  const fetchTickets = async () => {
    try {
      const data = await TicketService.getAllTickets();
      setTickets(data);
    } catch {
      alert("Error al cargar los tickets.");
    }
  };

  useEffect(() => {
    fetchTickets();
  }, []);
  const openModal = () => {
    setIsModalOpen(true);
    setProveedor("");
    setIncidente("");
  };

  const closeModal = () => {
    setIsModalOpen(false);
  };

  const handleSubmit = async (e: React.FormEvent) => {
    e.preventDefault();

    if (!proveedor.trim() || !incidente.trim()) {
      alert("Por favor complete todos los campos");
      return;
    }

    try {
      const newTicket = await TicketService.createTicket({
        proveedor,
        incidente,
      });
      if (newTicket) {
        await fetchTickets();
        closeModal();
      }
    } catch {
      alert("Error al crear ticket. Por favor, intente de nuevo.");
    }
  };
  return (
    <div>
      <h2>Lista de Tickets</h2>
      <button className="add-ticket-button" onClick={openModal}>
        Agregar Ticket
      </button>

      {tickets.length === 0 ? (
        <p>No se encontraron tickets</p>
      ) : (
        <table className="ticket-table">
          <thead>
            <tr>
              <th>ID</th>
              <th>Proveedor</th>
              <th>Incidente</th>
            </tr>
          </thead>
          <tbody>
            {tickets.map((ticket) => (
              <tr key={ticket.id}>
                <td>{ticket.id}</td>
                <td>{ticket.proveedor}</td>
                <td>{ticket.incidente}</td>
              </tr>
            ))}
          </tbody>
        </table>
      )}

      {isModalOpen && (
        <div className="modal-backdrop">
          {" "}
          <div className="modal-content">
            <h3>Agregar Nuevo Ticket</h3>
            <form onSubmit={handleSubmit}>
              {" "}
              <div className="form-group">
                <label htmlFor="proveedor">Proveedor:</label>{" "}
                <input
                  type="text"
                  id="proveedor"
                  name="proveedor"
                  value={proveedor}
                  onChange={(e) => setProveedor(e.target.value)}
                  required
                />
              </div>
              <div className="form-group">
                <label htmlFor="incidente">Incidente:</label>{" "}
                <input
                  type="text"
                  id="incidente"
                  name="incidente"
                  value={incidente}
                  onChange={(e) => setIncidente(e.target.value)}
                  required
                />
              </div>
              <div className="form-actions">
                <button
                  type="button"
                  className="cancel-button"
                  onClick={closeModal}
                >
                  Cancelar
                </button>
                <button type="submit" className="submit-button">
                  Crear Ticket
                </button>
              </div>
            </form>
          </div>
        </div>
      )}
    </div>
  );
}
