package com.techzen.techlearn.service;

import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public interface AIService {
    String callAPI(String request) throws IOException, InterruptedException;
}
