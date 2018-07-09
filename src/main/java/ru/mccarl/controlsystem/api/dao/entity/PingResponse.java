package ru.mccarl.controlsystem.api.dao.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PingResponse {

    private Server server;

    private String status;

    private LocalDateTime date;

    private String error;

    public PingResponse(Server server, String status, LocalDateTime date, String error) {
        this.server = server;
        this.status = status;
        this.date = date;
        this.error = error;
    }

    public PingResponse(Server server, String status, LocalDateTime date) {
        this.server = server;
        this.status = status;
        this.date = date;
    }
}
