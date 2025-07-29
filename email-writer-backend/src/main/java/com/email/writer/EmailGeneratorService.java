package com.email.writer;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Map;

@Service
public class EmailGeneratorService {

    private final WebClient webClient;

    @Value("${gemini.api.url}")
    private String geminiApiUrl;

    @Value("${gemini.api.key}")
    private String geminiApiKey;

    public EmailGeneratorService(WebClient.Builder builder) {
        this.webClient = builder.build();
    }

    public String generateEmailReply(EmailRequest emailRequest){
        System.out.println("Final URL: " + geminiApiUrl + geminiApiKey);

        // Build the prompt
        String prompt=buildPrompt(emailRequest);

        // craft a request
        Map<String,Object> requestBody=Map.of(
                "contents", new Object[]{
                        Map.of("parts", new Object[]{
                                Map.of("text",prompt)
                        })
                }
        );

        // Do request and get response
        String response=webClient.post()
                .uri(geminiApiUrl+geminiApiKey)
                .header("Content-Type","application/json")
                .bodyValue(requestBody)
                .retrieve()
                .bodyToMono(String.class)
                .block();

        // Extract response and return it
        return extractResponseContent(response);
    }

    private String extractResponseContent(String response) {
        try{
            ObjectMapper mapper=new ObjectMapper();
            JsonNode rootNode=mapper.readTree(response);
            return rootNode.path("candidates")
                    .get(0)
                    .path("content")
                    .path("parts")
                    .get(0)
                    .path("text")
                    .asText();
        }catch (Exception e){
            return "Error processing request: "+e.getMessage();
        }
    }

    private String buildPrompt(EmailRequest emailRequest) {
        StringBuilder prompt = new StringBuilder();
        prompt.append("Generate a reply to the following email.\n");

        if (emailRequest.getTone() != null && !emailRequest.getTone().isEmpty()) {
            String tone = emailRequest.getTone().toLowerCase();

            if (tone.equals("professional")) {
                prompt.append("Use a professional tone. Include a proper Subject line in the reply. ");
//                prompt.append("Do not include any placeholders like [Your Name] or [Sender Name]. ");
            } else {
                prompt.append("Use a ").append(tone).append(" tone. ");
                prompt.append("Do not include a Subject line or any placeholders like [Your Name] or [Sender Name]. ");
            }
        }

        prompt.append("\nOriginal email:\n").append(emailRequest.getEmailContent());
        return prompt.toString();
    }

}
