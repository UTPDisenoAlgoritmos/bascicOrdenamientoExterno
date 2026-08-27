# Mezcla Directa y Fusión Natural con un array

Array de ejemplo:

```text
[7,8,4,1,5,6,7,5,4,9,4,5,6,3,2.7,9,5,4]
```

## Objetivo

Ordenar el arreglo en forma ascendente usando:

1. Mezcla Directa
2. Fusión Natural

y mostrar:

- corridas iniciales,
- pasadas de fusión,
- comparaciones,
- movimientos,
- tiempo de ejecución.

## Resultado esperado

```text
[1.0, 2.7, 3.0, 4.0, 4.0, 4.0, 4.0, 5.0, 5.0, 5.0, 5.0, 6.0, 6.0, 7.0, 7.0, 8.0, 9.0, 9.0]
```

## Ejecutar

Requisitos:

- Java 17
- Maven 3.x

```bash
mvn clean compile
mvn exec:java
```

## Nota didáctica

Este proyecto usa un `double[]` para visualizar con claridad el funcionamiento
de las fusiones. Por tanto, es una simulación en memoria del comportamiento de
los algoritmos. En una ordenación externa real, las corridas se almacenan en
archivos temporales y las métricas de lectura/escritura a disco cobran mayor
importancia.
