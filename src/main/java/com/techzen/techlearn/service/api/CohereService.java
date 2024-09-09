package com.techzen.techlearn.service.api;

import com.cohere.api.Cohere;
import com.cohere.api.requests.ChatRequest;
import com.cohere.api.types.NonStreamedChatResponse;
import com.techzen.techlearn.service.AIService;
import org.springframework.stereotype.Service;

@Service("cohere")
public class CohereService implements AIService {

    @Override
    public String callAPI(String request) {
        Cohere cohere = Cohere.builder().token("pS0GWv4odrVCZXzU6EDVJry1sdZLu3JdCEmyK26B").clientName("snippet").build();
        NonStreamedChatResponse response = cohere.chat(
                ChatRequest.builder()
                        .message(request).build());
        System.out.println(response);
        return response.toString();
    }
}
