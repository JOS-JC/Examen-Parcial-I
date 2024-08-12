public class Factura {
    private Reserva reserva;
    private double montoTotal;

    public Factura(Reserva reserva) {
        this.reserva = reserva;
        this.montoTotal = reserva.calcularCosto();
    }

    public Reserva getReserva() {
        return reserva;
    }

    public double getMontoTotal() {
        return montoTotal;
    }
}