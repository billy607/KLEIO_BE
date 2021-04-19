package com.kleio.app.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UpdateRequest {

    @JsonProperty("userId")
    private int userId;

    @JsonProperty("name")
    private String name;

    @JsonProperty("password")
    private String password;
}
