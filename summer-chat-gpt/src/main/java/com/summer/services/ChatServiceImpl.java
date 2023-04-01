package com.summer.services;

import com.summer.models.Response;
import com.theokanning.openai.completion.CompletionChoice;
import com.theokanning.openai.completion.CompletionRequest;
import com.theokanning.openai.image.CreateImageRequest;
import com.theokanning.openai.image.Image;
import com.theokanning.openai.service.OpenAiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ChatServiceImpl implements ChatService {


    @Autowired
    private OpenAiService openAiService;


    @Override
    public Response chat(String inputContent) {
        //基本聊天
        CompletionRequest completionRequest = CompletionRequest.builder()
                .prompt(inputContent)
                .model("text-davinci-003")
                .echo(true)
                .temperature(0.7)
                .topP(1d)
                .frequencyPenalty(0d)
                .presencePenalty(0d)
                .maxTokens(1000)
                .build();

        List<String> result = new ArrayList<>();
        List<CompletionChoice> choices = openAiService.createCompletion(completionRequest).getChoices();
        for (CompletionChoice choice : choices) {
            result.add(choice.getText());
        }
        return Response.build(1, result);
    }


    @Override
    public Response draw(String inputContent) {
        //图片
        CreateImageRequest request = CreateImageRequest.builder()
                .prompt(inputContent)
                .build();
        List<String> result = new ArrayList<>();
        List<Image> images = openAiService.createImage(request).getData();
        for (Image image : images) {
            result.add(image.getUrl());
        }
        return Response.build(2, result);
    }
}
