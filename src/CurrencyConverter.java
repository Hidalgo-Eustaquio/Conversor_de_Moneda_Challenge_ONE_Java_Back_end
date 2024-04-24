import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class CurrencyConverter {
    private final String apiKey;

    public CurrencyConverter(String apiKey) {
        this.apiKey = apiKey;
    }

    public double convert(String fromCurrency, String toCurrency, double amount) throws Exception {
        String urlStr = "https://v6.exchangerate-api.com/v6/" + apiKey + "/pair/" +
                URLEncoder.encode(fromCurrency, StandardCharsets.UTF_8) + "/" +
                URLEncoder.encode(toCurrency, StandardCharsets.UTF_8) + "/" +
                amount;
        URL url = new URL(urlStr);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        JsonObject response = JsonParser.parseReader(reader).getAsJsonObject();
        reader.close();

        response.get("conversion_rate").getAsDouble();

        return response.get("conversion_result").getAsDouble();
    }
}


