package com.summer.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Response {

    private Integer completionType;

    private List<String> completionContents;

    public static Response build(Integer completionType, List<String> completionContents) {
        return new Response(completionType, completionContents);
    }

}
