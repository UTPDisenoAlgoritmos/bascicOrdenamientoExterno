package pe.edu.utp.algoritmos;

import java.util.Arrays;

/**
 * Mezcla Directa sobre un array.
 *
 * Idea:
 * - Se consideran corridas de tamaño 1.
 * - En cada pasada se fusionan corridas adyacentes.
 * - El tamaño de corrida se duplica: 1, 2, 4, 8, 16...
 *
 * Este programa sirve para visualizar el comportamiento del algoritmo
 * con el array dado en clase.
 */
public class MezclaDirecta {

    public static Resultado ordenar(double[] original) {
        double[] a = Arrays.copyOf(original, original.length);
        double[] aux = new double[a.length];
        Metricas m = new Metricas("Mezcla Directa");

        // En mezcla directa clásica, inicialmente cada elemento
        // puede verse como una corrida ordenada de tamaño 1.
        for (int i = 0; i < a.length; i++) {
            m.corridaInicial();
        }

        long inicio = System.nanoTime();

        System.out.println("\n================ MEZCLA DIRECTA ================");
        System.out.println("Entrada : " + Arrays.toString(a));

        for (int ancho = 1; ancho < a.length; ancho *= 2) {
            m.pasada();

            System.out.println("\nPasada " + m.pasadas()
                    + " | tamaño de corrida = " + ancho);

            for (int izq = 0; izq < a.length; izq += 2 * ancho) {
                int medio = Math.min(izq + ancho, a.length);
                int der = Math.min(izq + 2 * ancho, a.length);

                fusionar(a, aux, izq, medio, der, m);
            }

            // Copiamos el resultado auxiliar al arreglo principal.
            for (int i = 0; i < a.length; i++) {
                a[i] = aux[i];
                m.movimiento();
            }

            System.out.println("Estado  : " + Arrays.toString(a));
        }

        m.setTiempoNs(System.nanoTime() - inicio);
        return new Resultado(a, m);
    }

    private static void fusionar(
            double[] a,
            double[] aux,
            int izq,
            int medio,
            int der,
            Metricas m) {

        int i = izq;
        int j = medio;
        int k = izq;

        while (i < medio && j < der) {
            m.comparacion();

            if (a[i] <= a[j]) {
                aux[k++] = a[i++];
            } else {
                aux[k++] = a[j++];
            }
            m.movimiento();
        }

        while (i < medio) {
            aux[k++] = a[i++];
            m.movimiento();
        }

        while (j < der) {
            aux[k++] = a[j++];
            m.movimiento();
        }
    }

    public record Resultado(double[] datos, Metricas metricas) {}
}
