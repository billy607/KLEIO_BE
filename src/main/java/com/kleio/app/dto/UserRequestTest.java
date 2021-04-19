package com.kleio.app.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UserRequestTest {

    @JsonProperty("name")
    private String name;

    @JsonProperty("password")
    private String password;
}
