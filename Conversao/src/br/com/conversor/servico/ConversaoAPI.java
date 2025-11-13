package br.com.conversor.servico;

import br.com.conversor.modelo.RespostaConversao;
import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConversaoAPI {

    private static final String API_KEY = "9b254120051cf4f844816b11";
    private static final String BASE_URL = "https://v6.exchangerate-api.com/v6/";

    public RespostaConversao converter(String moedaBase, String moedaAlvo, double valor) {
        String urlCompleta = BASE_URL + API_KEY + "/pair/" +
                moedaBase + "/" + moedaAlvo + "/" + valor;

        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(urlCompleta))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                String jsonResponse = response.body();

                Gson gson = new Gson();
                return gson.fromJson(jsonResponse, RespostaConversao.class);
            } else {
                System.err.println("Erro na chamada da API. Código de Status: " + response.statusCode());
                System.err.println("Verifique se a API Key foi inserida corretamente no arquivo ConversaoAPI.java.");
                return null;
            }

        } catch (Exception e) {
            System.err.println("Ocorreu um erro ao tentar conectar à API. Verifique sua conexão com a internet.");
            return null;
        }
    }
}