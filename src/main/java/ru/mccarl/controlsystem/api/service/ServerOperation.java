package ru.mccarl.controlsystem.api.service;

import ru.mccarl.controlsystem.api.dao.entity.PingResponse;
import ru.mccarl.controlsystem.api.dao.entity.Server;
import ru.mccarl.controlsystem.api.dao.entity.SheduleSetting;

import java.util.List;

public interface ServerOperation {

    void saveSetting(SheduleSetting sheduleSetting);

    SheduleSetting getSettings();

    void saveServer(Server server);

    List<Server> getServers();

    void updateServer(Server server);

    void updateSetting(SheduleSetting sheduleSetting);

    List<PingResponse> getInfo();

}
