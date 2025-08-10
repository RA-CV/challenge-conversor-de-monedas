package lad.com.alura.conversormoneda;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Conversor {

    public static void eleccionUserMenu() throws IOException, InterruptedException {
        Scanner sc = new Scanner(System.in);
        int opcion;

        Map<Integer, String[]> opcionesMonedas = new HashMap<>();
        opcionesMonedas.put(1, new String[]{"USD", "MXN"});
        opcionesMonedas.put(2, new String[]{"MXN", "USD"});
        opcionesMonedas.put(3, new String[]{"USD", "BRL"});
        opcionesMonedas.put(4, new String[]{"BRL", "USD"});
        opcionesMonedas.put(5, new String[]{"USD", "COP"});
        opcionesMonedas.put(6, new String[]{"COP", "USD"});

        do {
            System.out.println("""
                    ********************************************************************************
                    Sea bienvenido/a al Conversor de Moneda =]

                    1) Dólar => Peso mexicano
                    2) Peso mexicano => Dólar
                    3) Dólar => Peso brasileño
                    4) Peso brasileño => Dólar
                    5) Dólar => Peso colombiano
                    6) Peso colombiano => Dólar
                    7) Salir
                    Elija una opción válida:
                    ********************************************************************************
                    """);
            opcion = sc.nextInt();

            if (opcion >= 1 && opcion <= 6) {
                System.out.print("Ingrese la cantidad a convertir: ");
                double cantidad = sc.nextDouble();

                String[] monedas = opcionesMonedas.get(opcion);
                String monedaOrigen = monedas[0];
                String monedaDestino = monedas[1];

                // Obtiene las tasas para monedaOrigen y monedaDestino
                double tasaOrigen = ConversorApp.obtenerTasa(monedaOrigen);
                double tasaDestino = ConversorApp.obtenerTasa(monedaDestino);

                // Convierte la cantidad
                double cantidadEnUSD = cantidad / tasaOrigen;
                double cantidadConvertida = cantidadEnUSD * tasaDestino;

                System.out.printf("%.2f %s equivale a %.2f %s%n%n",
                        cantidad, monedaOrigen, cantidadConvertida, monedaDestino);
            } else if (opcion == 7) {
                System.out.println("Gracias por usar el conversor. ¡Hasta luego!");
            } else {
                System.out.println("Opción inválida, intenta de nuevo.\n");
            }
        } while (opcion != 7);

        sc.close();
    }
}