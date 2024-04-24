import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String apiKey = "d6da4fe0b147533120abcfc5"; // Reemplaza "tu_api_key" con tu propia API key
        CurrencyConverter converter = new CurrencyConverter(apiKey);
        Scanner scanner = new Scanner(System.in);

        try (scanner) {
            Menu menu = new Menu(converter, scanner);
            menu.mostrarMenu();
        }
    }
}
