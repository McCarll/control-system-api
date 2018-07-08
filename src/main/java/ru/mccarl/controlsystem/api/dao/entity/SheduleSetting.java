package ru.mccarl.controlsystem.api.dao.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
@AllArgsConstructor
public class SheduleSetting {

    @NotNull
    @Pattern(regexp = "\\d+")
    private String sheduleTime;

}
