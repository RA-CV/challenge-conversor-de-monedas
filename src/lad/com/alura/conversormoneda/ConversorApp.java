package lad.com.alura.conversormoneda;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

public class ConversorApp {

    private static final String API_KEY = "b84e3bfb98a31ed4c18a77c0";
    private static final String URL_BASE = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/latest/USD";

    // Obtiene la tasa de cambio para una moneda destino
    public static double obtenerTasa(String monedaDestino) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(URL_BASE))
                .timeout(Duration.ofSeconds(10))
                .header("Accept", "application/json")
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() != 200) {
            throw new IOException("Error al llamar API, código: " + response.statusCode());
        }

        JsonObject root = JsonParser.parseString(response.body()).getAsJsonObject();
        JsonObject rates = root.getAsJsonObject("conversion_rates");

        if (!rates.has(monedaDestino)) {
            throw new IllegalArgumentException("Moneda no soportada: " + monedaDestino);
        }

        return rates.get(monedaDestino).getAsDouble();
    }
    public static void main(String[] args) {
        try {
            Conversor.eleccionUserMenu();
        } catch (IOException | InterruptedException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
