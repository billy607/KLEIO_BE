package com.kleio.app.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
public class User {

    @JsonProperty("id")
    private UUID id;

    @JsonProperty("name")
    private String name;
}
