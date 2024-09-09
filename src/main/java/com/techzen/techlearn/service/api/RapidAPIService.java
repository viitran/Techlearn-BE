package com.techzen.techlearn.service.api;

import com.techzen.techlearn.service.AIService;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
@Primary
@Service("rapid")
public class RapidAPIService implements AIService {
    @Override
    public String callAPI(String mess) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://chatgpt-42.p.rapidapi.com/chatgpt"))
                .header("x-rapidapi-key", "4c5205c5aemsh54e9f600c1c69c7p1dad90jsn9d56ef2040c7")
                .header("x-rapidapi-host", "chatgpt-42.p.rapidapi.com")
                .header("Content-Type", "application/json")
                .method("POST", HttpRequest.BodyPublishers.ofString("{\"messages\":[{\"role\":\"user\",\"content\":\"" + mess + "\"}],\"web_access\":false}"))
                .build();
        return HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString()).body();
    }
}
