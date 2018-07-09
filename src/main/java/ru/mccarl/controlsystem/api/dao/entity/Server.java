package ru.mccarl.controlsystem.api.dao.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class Server {

    @NotNull
    private String url;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String oldUrl;

}
