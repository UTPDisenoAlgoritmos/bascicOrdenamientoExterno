package pe.edu.utp.algoritmos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Fusión Natural sobre un array.
 *
 * Idea:
 * - Primero detecta corridas naturales: segmentos que ya están
 *   ordenados de forma no decreciente.
 * - Luego fusiona las corridas de dos en dos.
 * - Repite hasta obtener una sola corrida.
 */
public class FusionNatural {

    public static Resultado ordenar(double[] original) {
        Metricas m = new Metricas("Fusión Natural");
        long inicio = System.nanoTime();

        System.out.println("\n================ FUSIÓN NATURAL ================");
        System.out.println("Entrada : " + Arrays.toString(original));

        List<double[]> corridas = detectarCorridas(original, m);

        System.out.println("\nCorridas naturales iniciales:");
        imprimirCorridas(corridas);

        while (corridas.size() > 1) {
            m.pasada();
            List<double[]> nuevas = new ArrayList<>();

            for (int i = 0; i < corridas.size(); i += 2) {
                if (i + 1 < corridas.size()) {
                    nuevas.add(fusionar(corridas.get(i), corridas.get(i + 1), m));
                } else {
                    nuevas.add(corridas.get(i));
                }
            }

            corridas = nuevas;

            System.out.println("\nPasada de fusión " + m.pasadas()
                    + " | corridas resultantes:");
            imprimirCorridas(corridas);
        }

        double[] ordenado = corridas.isEmpty()
                ? new double[0]
                : corridas.get(0);

        m.setTiempoNs(System.nanoTime() - inicio);
        return new Resultado(ordenado, m);
    }

    private static List<double[]> detectarCorridas(double[] a, Metricas m) {
        List<double[]> corridas = new ArrayList<>();

        if (a.length == 0) {
            return corridas;
        }

        int inicio = 0;

        for (int i = 1; i < a.length; i++) {
            m.comparacion();

            if (a[i] < a[i - 1]) {
                corridas.add(Arrays.copyOfRange(a, inicio, i));
                m.corridaInicial();
                inicio = i;
            }
        }

        corridas.add(Arrays.copyOfRange(a, inicio, a.length));
        m.corridaInicial();

        return corridas;
    }

    private static double[] fusionar(double[] a, double[] b, Metricas m) {
        double[] r = new double[a.length + b.length];
        int i = 0;
        int j = 0;
        int k = 0;

        while (i < a.length && j < b.length) {
            m.comparacion();

            if (a[i] <= b[j]) {
                r[k++] = a[i++];
            } else {
                r[k++] = b[j++];
            }
            m.movimiento();
        }

        while (i < a.length) {
            r[k++] = a[i++];
            m.movimiento();
        }

        while (j < b.length) {
            r[k++] = b[j++];
            m.movimiento();
        }

        return r;
    }

    private static void imprimirCorridas(List<double[]> corridas) {
        for (int i = 0; i < corridas.size(); i++) {
            System.out.println("Run " + (i + 1) + ": "
                    + Arrays.toString(corridas.get(i)));
        }
    }

    public record Resultado(double[] datos, Metricas metricas) {}
}
