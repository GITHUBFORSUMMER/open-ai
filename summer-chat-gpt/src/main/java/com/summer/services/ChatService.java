package com.summer.services;

import com.summer.models.Response;

public interface ChatService {


    Response chat(String inputContent);


    Response draw(String inputContent);

}
