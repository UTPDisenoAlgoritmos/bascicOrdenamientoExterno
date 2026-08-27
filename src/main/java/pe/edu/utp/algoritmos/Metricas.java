package pe.edu.utp.algoritmos;

public class Metricas {
    private final String algoritmo;
    private long comparaciones;
    private long movimientos;
    private long pasadas;
    private long corridasIniciales;
    private double tiempoMs;

    public Metricas(String algoritmo) {
        this.algoritmo = algoritmo;
    }

    public void comparacion() { comparaciones++; }
    public void movimiento() { movimientos++; }
    public void pasada() { pasadas++; }
    public void corridaInicial() { corridasIniciales++; }

    public String algoritmo() { return algoritmo; }
    public long comparaciones() { return comparaciones; }
    public long movimientos() { return movimientos; }
    public long pasadas() { return pasadas; }
    public long corridasIniciales() { return corridasIniciales; }
    public double tiempoMs() { return tiempoMs; }

    public void setTiempoNs(long ns) {
        this.tiempoMs = ns / 1_000_000.0;
    }
}
