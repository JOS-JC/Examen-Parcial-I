import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;

public class HotelGestion {
    private Map<Integer, Habitacion> habitaciones;
    private Map<String, Cliente> clientes;
    private List<Reserva> reservas;
    private List<Factura> facturas;

    public HotelGestion() {
        habitaciones = new HashMap<>();
        clientes = new HashMap<>();
        reservas = new ArrayList<>();
        facturas = new ArrayList<>();
    }

    public void registrarHabitacion(int numero, String tipo, double precioPorNoche) {
        habitaciones.put(numero, new Habitacion(numero, tipo, precioPorNoche));
    }

    public void registrarCliente(String nombre, String id) {
        clientes.put(id, new Cliente(nombre, id));
    }

    public void crearReserva(String clienteId, int numeroHabitacion, LocalDate fechaEntrada, LocalDate fechaSalida) throws HabitacionNoDisponibleException, ClienteNoEncontradoException {
        Cliente cliente = clientes.get(clienteId);
        if (cliente == null) {
            throw new ClienteNoEncontradoException("Cliente no encontrado.");
        }

        Habitacion habitacion = habitaciones.get(numeroHabitacion);
        if (habitacion == null || !"disponible".equals(habitacion.getEstado())) {
            throw new HabitacionNoDisponibleException("Habitación no disponible.");
        }

        Reserva reserva = new Reserva(cliente, habitacion, fechaEntrada, fechaSalida);
        reservas.add(reserva);
        cliente.agregarReserva(reserva);
        habitacion.setEstado("ocupada");
    }

    public void registrarFactura(String clienteId, int numeroHabitacion) throws ClienteNoEncontradoException {
        Cliente cliente = clientes.get(clienteId);
        if (cliente == null) {
            throw new ClienteNoEncontradoException("Cliente no encontrado.");
        }

        Reserva reserva = reservas.stream()
                .filter(r -> r.getCliente().getId().equals(clienteId) && r.getHabitacion().getNumero() == numeroHabitacion)
                .findFirst()
                .orElse(null);

        if (reserva != null) {
            Factura factura = new Factura(reserva);
            facturas.add(factura);
            cliente.agregarFactura(factura);
        }
    }

    public List<Habitacion> consultarHabitaciones() {
        return new ArrayList<>(habitaciones.values());
    }

    public List<Reserva> consultarReservasActivas() {
        return new ArrayList<>(reservas);
    }

    public List<Factura> consultarFacturas() {
        return new ArrayList<>(facturas);
    }
}
