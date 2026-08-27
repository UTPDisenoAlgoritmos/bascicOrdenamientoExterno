package pe.edu.utp.algoritmos;

import java.util.Arrays;
import java.util.Locale;

public class Main {

    public static void main(String[] args) {

        double[] datos = {
                7, 8, 4, 1, 5, 6, 7, 5, 4,
                9, 4, 5, 6, 3, 2.7, 9, 5, 4
        };

        System.out.println("ARRAY ORIGINAL");
        System.out.println(Arrays.toString(datos));
        System.out.println("Cantidad de elementos: " + datos.length);

        MezclaDirecta.Resultado directa =
                MezclaDirecta.ordenar(datos);

        FusionNatural.Resultado natural =
                FusionNatural.ordenar(datos);

        System.out.println("\n============================================================");
        System.out.println("RESULTADO FINAL");
        System.out.println("============================================================");
        System.out.println("Mezcla Directa: "
                + Arrays.toString(directa.datos()));
        System.out.println("Fusión Natural : "
                + Arrays.toString(natural.datos()));

        System.out.println("\n============================================================");
        System.out.println("MÉTRICAS");
        System.out.println("============================================================");

        imprimirMetricas(directa.metricas());
        imprimirMetricas(natural.metricas());

        System.out.println("\nInterpretación:");
        System.out.println("- Comparaciones: evaluaciones entre valores.");
        System.out.println("- Movimientos: escrituras/copias realizadas durante la fusión.");
        System.out.println("- Pasadas: rondas completas de fusión.");
        System.out.println("- Corridas iniciales: bloques ordenados considerados al inicio.");
        System.out.println("- El tiempo puede variar entre ejecuciones.");
    }

    private static void imprimirMetricas(Metricas m) {
        System.out.printf(
                Locale.US,
                "%-16s | corridas=%2d | pasadas=%2d | comparaciones=%3d | movimientos=%3d | tiempo=%.3f ms%n",
                m.algoritmo(),
                m.corridasIniciales(),
                m.pasadas(),
                m.comparaciones(),
                m.movimientos(),
                m.tiempoMs()
        );
    }
}
