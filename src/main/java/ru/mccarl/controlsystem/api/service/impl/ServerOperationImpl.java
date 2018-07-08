package ru.mccarl.controlsystem.api.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import ru.mccarl.controlsystem.api.dao.entity.InMemoryDb;
import ru.mccarl.controlsystem.api.dao.entity.PingResponse;
import ru.mccarl.controlsystem.api.dao.entity.Server;
import ru.mccarl.controlsystem.api.dao.entity.SheduleSetting;
import ru.mccarl.controlsystem.api.pinger.PingerController;
import ru.mccarl.controlsystem.api.service.ServerOperation;

import java.util.*;

@Service
@Slf4j
public class ServerOperationImpl implements ServerOperation {

    @Autowired
    private InMemoryDb inMemoryDb;

    @Autowired
    private PingerController pingerController;

    @Override
    public void saveSetting(SheduleSetting sheduleSetting) {
        inMemoryDb.changeSetting(sheduleSetting);
    }

    public SheduleSetting getSettings() {
        return inMemoryDb.getSettings();
    }

    @Override
    public void saveServer(Server server) {
        inMemoryDb.addServer(server);
    }

    @Override
    public List<Server> getServers() {
        return inMemoryDb.getServers();
    }

    @Override
    public void updateServer(Server server) {
        if (!StringUtils.isEmpty(server.getOldUrl())) {
            int index = inMemoryDb.getServers().indexOf(server.getOldUrl());
            inMemoryDb.updateServer(index, server);
        }
    }

    @Override
    public void updateSetting(SheduleSetting sheduleSetting) {
        inMemoryDb.updateSettings(sheduleSetting);
        pingerController.restartPinger();
    }

    @Override
    public List<PingResponse> getInfo(){
        return inMemoryDb.getInfo();
    }

}
