// Cliente.java
import java.util.ArrayList;
import java.util.List;

public class Cliente extends Persona {
    private List<Reserva> reservas;
    private List<Factura> facturas;

    public Cliente(String nombre, String id) {
        super(nombre, id);
        reservas = new ArrayList<>();
        facturas = new ArrayList<>();
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public List<Factura> getFacturas() {
        return facturas;
    }

    public void agregarReserva(Reserva reserva) {
        reservas.add(reserva);
    }

    public void agregarFactura(Factura factura) {
        facturas.add(factura);
    }
}