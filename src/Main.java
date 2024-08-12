import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        try {
            // Crear instancia del sistema de gestión
            HotelGestion hotelGestion = new HotelGestion();

            // Registrar habitaciones
            hotelGestion.registrarHabitacion(101, "individual", 50.0);
            hotelGestion.registrarHabitacion(102, "doble", 75.0);
            hotelGestion.registrarHabitacion(103, "suite", 120.0);

            // Registrar clientes
            hotelGestion.registrarCliente("Juan Pérez", "C001");
            hotelGestion.registrarCliente("Ana Gómez", "C002");

            // Crear reservas
            hotelGestion.crearReserva("C001", 101, LocalDate.of(2024, 8, 10), LocalDate.of(2024, 8, 15));
            hotelGestion.crearReserva("C002", 102, LocalDate.of(2024, 8, 12), LocalDate.of(2024, 8, 20));

            // Registrar facturas
            hotelGestion.registrarFactura("C001", 101);
            hotelGestion.registrarFactura("C002", 102);

            // Consultar información
            System.out.println("Habitaciones:");
            for (Habitacion hab : hotelGestion.consultarHabitaciones()) {
                System.out.println("Número: " + hab.getNumero() + ", Tipo: " + hab.getTipo() + ", Precio por noche: " + hab.getPrecioPorNoche() + ", Estado: " + hab.getEstado());
            }

            System.out.println("\nReservas Activas:");
            for (Reserva res : hotelGestion.consultarReservasActivas()) {
                System.out.println("Cliente: " + res.getCliente().getNombre() + ", Habitación: " + res.getHabitacion().getNumero() + ", Desde: " + res.getFechaEntrada() + ", Hasta: " + res.getFechaSalida());
            }

            System.out.println("\nFacturas Generadas:");
            for (Factura fac : hotelGestion.consultarFacturas()) {
                System.out.println("Cliente: " + fac.getReserva().getCliente().getNombre() + ", Monto Total: " + fac.getMontoTotal());
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}