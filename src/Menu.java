import java.util.Scanner;

public class Menu {
    private final CurrencyConverter converter;
    private final Scanner scanner;

    public Menu(CurrencyConverter converter, Scanner scanner) {
        this.converter = converter;
        this.scanner = scanner;
    }

    public void mostrarMenu() {
        int opcion;
        do {
            System.out.println("****************************************");
            System.out.println("---- Menú de Conversión de Moneda ----");
            System.out.println("1. USD a Pesos Argentinos");
            System.out.println("2. Pesos Argentinos a USD");
            System.out.println("3. USD a Real Brasileño");
            System.out.println("4. Real Brasileño a USD");
            System.out.println("5. USD a Peso Colombiano");
            System.out.println("6. Peso Colombiano a USD");
            System.out.println("7. Salir de la Aplicación");
            System.out.print("Elija una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    convertirMoneda("USD", "ARS");
                    break;
                case 2:
                    convertirMoneda("ARS", "USD");
                    break;
                case 3:
                    convertirMoneda("USD", "BRL");
                    break;
                case 4:
                    convertirMoneda("BRL", "USD");
                    break;
                case 5:
                    convertirMoneda("USD", "COP");
                    break;
                case 6:
                    convertirMoneda("COP", "USD");
                    break;
                case 7:
                    System.out.println("Saliendo de la aplicación...");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
            }
        } while (opcion != 7);
    }

    private void convertirMoneda(String fromCurrency, String toCurrency) {
        try {
            System.out.print("Ingrese el monto a convertir: ");
            double amount = scanner.nextDouble();
            double resultado = converter.convert(fromCurrency, toCurrency, amount);
            System.out.println(amount + " " + fromCurrency + " = " + resultado + " " + toCurrency);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

