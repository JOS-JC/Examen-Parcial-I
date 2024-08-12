public class Habitacion {
    private int numero;
    private String tipo; // Puede ser "individual", "doble", "suite"
    private double precioPorNoche;
    private String estado; // Puede ser "disponible", "ocupada", "en limpieza"

    public Habitacion(int numero, String tipo, double precioPorNoche) {
        this.numero = numero;
        this.tipo = tipo;
        this.precioPorNoche = precioPorNoche;
        this.estado = "disponible";
    }

    public int getNumero() {
        return numero;
    }

    public String getTipo() {
        return tipo;
    }

    public double getPrecioPorNoche() {
        return precioPorNoche;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}