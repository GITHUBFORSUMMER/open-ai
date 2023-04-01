package com.summer.configs;

import com.theokanning.openai.service.OpenAiService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;

@Data
@Configuration
public class OpenAiSettings {

    @Value("${open.ai.key}")
    private String openAiKey;

    @Bean
    public OpenAiService openAiService() {
        return new OpenAiService(openAiKey, Duration.ofHours(1));
    }

}
