package ru.mccarl.controlsystem.api.web;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.mccarl.controlsystem.api.dao.entity.PingResponse;
import ru.mccarl.controlsystem.api.dao.entity.Server;
import ru.mccarl.controlsystem.api.dao.entity.SheduleSetting;
import ru.mccarl.controlsystem.api.service.ServerOperation;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@Configuration
@RequestMapping(produces = "application/json")
public class Controller {

    @Autowired
    private ServerOperation serverOperation;

    @ApiOperation(value = "Get list of servers")
    @GetMapping(value = "/server")
    public Map<String, List<Server>> getServers() {
        Map<String, List<Server>> response = new HashMap<>();
        response.put("data", serverOperation.getServers());
        return response;
    }

    @ApiOperation(value = "Get current settings")
    @GetMapping(value = "/setting")
    public Map<String, SheduleSetting> getSettings() {
        Map<String, SheduleSetting> response = new HashMap<>();
        response.put("data", serverOperation.getSettings());
        return response;
    }

    @ApiOperation(value = "Update server")
    @PatchMapping(value = "/server")
    public ResponseEntity updateServer(@RequestBody @Valid Server server) {
        serverOperation.updateServer(server);
        return ResponseEntity.ok().build();
    }

    @ApiOperation(value = "Delete server")
    @DeleteMapping(value = "/server")
    public ResponseEntity deleteServer(@RequestBody @Valid Server server) {
        serverOperation.deleteServer(server);
        return ResponseEntity.ok().build();
    }

    @ApiOperation(value = "Update server setting")
    @PatchMapping(value = "/setting")
    public ResponseEntity updateSetting(@RequestBody @Valid SheduleSetting sheduleSetting) {
        serverOperation.updateSetting(sheduleSetting);
        return ResponseEntity.ok().build();
    }

    @ApiOperation(value = "Add server")
    @PostMapping(value = "/server")
    public ResponseEntity addServer(@RequestBody @Valid Server server) {
        serverOperation.saveServer(server);
        return ResponseEntity.ok().build();
    }

    @ApiOperation(value = "Change settings")
    @PutMapping(value = "/setting")
    public ResponseEntity updateSettings(@RequestBody @Valid SheduleSetting setting) {
        serverOperation.saveSetting(setting);
        return ResponseEntity.ok().build();
    }

    @ApiOperation(value = "Get pinger result")
    @GetMapping(value = "/pinger/logs")
    public Map<String, List<PingResponse>> getInfo() {
        Map<String, List<PingResponse>> response = new HashMap<>();
        response.put("data", serverOperation.getInfo());
        return response;
    }

}