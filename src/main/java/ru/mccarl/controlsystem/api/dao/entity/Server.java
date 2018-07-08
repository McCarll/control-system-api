package ru.mccarl.controlsystem.api.dao.entity;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class Server {

    @NotNull
    private String url;

    private String oldUrl;

}
