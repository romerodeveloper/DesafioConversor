import com.google.gson.*;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaMoneda {

    public double Conversion(String moneda, String unidadConvertida) {

        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/36dcb6214ccc35ab48d11c10/latest/"+moneda);
            try {
                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(direccion)
                        .build();

                HttpResponse<String> response = client
                        .send(request, HttpResponse.BodyHandlers.ofString());

                String json = response.body();
                //System.out.println(json);

                //convierte el string en json para poder extraer valores
                JsonObject jsonObject = JsonParser.parseString(json).getAsJsonObject();
                //extrae el conversion rates despues de crear el json, sino no lo reconoce
                JsonObject conversionRates = jsonObject.getAsJsonObject("conversion_rates");
                // Convertir el objeto extraído de nuevo a String
                //String conversionRatesJsonString = new Gson().toJson(conversionRates);

                // Imprimir el nuevo JSON con solo el objeto 'conversion_rates'
                //System.out.println("Nuevo JSON con solo 'conversion_rates':");
                //System.out.println(conversionRatesJsonString);

                double value = conversionRates.get(unidadConvertida).getAsDouble();

                return value;

            } catch (IOException | RuntimeException | InterruptedException e) {
                System.out.println("ocurrio un error: ");
                System.out.println(e.getMessage());
            }
        return 0;
    }

}
