package com.summer.controllers;

import com.summer.models.Response;
import com.summer.services.ChatService;
import com.theokanning.openai.completion.CompletionChoice;
import com.theokanning.openai.completion.CompletionRequest;
import com.theokanning.openai.service.OpenAiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/open/ai")
@RestController
public class OpenAIController {

    @Autowired
    private ChatService chatService;


    @PostMapping("/chat")
    public Response chat(@RequestParam("chatMessage") String chatMessage) {

        //return chatService.draw(chatMessage);
        return chatService.chat(chatMessage);
    }


    public static void main(String[] args) {
        OpenAiService service = new OpenAiService("abc");
        //基本聊天
        CompletionRequest completionRequest = CompletionRequest.builder()
                .prompt("who are you？")
                .model("text-davinci-003")
                .echo(true)
                .temperature(0.7)
                .topP(1d)
                .frequencyPenalty(0d)
                .presencePenalty(0d)
                .maxTokens(1000)
                .build();

        List<CompletionChoice> choices = service.createCompletion(completionRequest).getChoices();
        choices.forEach(System.out::println);

    }

}
