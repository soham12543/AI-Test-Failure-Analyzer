package ai;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import utility.ConfigReader;

public class GeminiClient {

    public String getAnalysis(String prompt) throws IOException, InterruptedException {

        String apiKey = ConfigReader.getProperty("gemini.api.key");

        HttpClient client = HttpClient.newHttpClient();

        JsonObject text = new JsonObject();
        text.addProperty("text", prompt);

        JsonArray parts = new JsonArray();
        parts.add(text);

        JsonObject content = new JsonObject();
        content.add("parts", parts);

        JsonArray contents = new JsonArray();
        contents.add(content);

        JsonObject requestBody = new JsonObject();
        requestBody.add("contents", contents);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(
                        "https://generativelanguage.googleapis.com/v1beta/models/gemini-2.5-flash:generateContent?key="
                                + apiKey))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(requestBody.toString()))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        // Print raw response
        System.out.println("=========== GEMINI RESPONSE ===========");
        System.out.println(response.body());
        System.out.println("=======================================");

        JsonObject jsonResponse = JsonParser.parseString(response.body()).getAsJsonObject();

        String answer = jsonResponse
                .getAsJsonArray("candidates")
                .get(0)
                .getAsJsonObject()
                .getAsJsonObject("content")
                .getAsJsonArray("parts")
                .get(0)
                .getAsJsonObject()
                .get("text")
                .getAsString();

        // Print extracted answer
        System.out.println("=========== AI ANALYSIS ===========");
        System.out.println(answer);
        System.out.println("===================================");

        return answer;
    }
}