package ru.mccarl.controlsystem.api.dao.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PingResponse {

    private String status;

    private LocalDateTime date;

    private String error;

    public PingResponse(String status, LocalDateTime date, String error) {
        this.status = status;
        this.date = date;
        this.error = error;
    }

    public PingResponse(String status, LocalDateTime date) {
        this.status = status;
        this.date = date;
    }
}
