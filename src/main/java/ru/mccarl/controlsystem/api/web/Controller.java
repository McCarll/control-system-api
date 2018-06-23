package ru.mccarl.controlsystem.api.web;

import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Configuration
@RequestMapping(produces = "application/json")
public class Controller {

    @Deprecated
    @ApiOperation(value = "Get health application")
    @GetMapping(value = "/health")
    public ResponseEntity getAccounts(){
        return ResponseEntity.ok("[{\"health\":\"ok\"}]");
    }

}