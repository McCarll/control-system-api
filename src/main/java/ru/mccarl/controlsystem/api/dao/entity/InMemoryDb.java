package ru.mccarl.controlsystem.api.dao.entity;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InMemoryDb {

    private static List<Server> SERVER_LIST = new ArrayList<>();

    private static SheduleSetting SETTING = new SheduleSetting("1000");

    private static List<PingResponse> CHECK_HISTORY = new ArrayList<>();

    public void savePingResponse(PingResponse pingResponse){
        CHECK_HISTORY.add(pingResponse);
    }

    public boolean addServer(Server server) {
        SERVER_LIST.add(server);
        return true;
    }

    public boolean changeSetting(SheduleSetting setting) {
        SETTING.setSheduleTime(setting.getSheduleTime());
        return true;
    }

    public SheduleSetting getSettings() {
        return SETTING;
    }

    public List<Server> getServers() {
        return SERVER_LIST;
    }

    public boolean updateServer(int index, Server server) {
        SERVER_LIST.get(index).setUrl(server.getUrl());
        return true;
    }

    public boolean updateSettings(SheduleSetting sheduleSetting) {
        SETTING = sheduleSetting;
        return true;
    }

    public List<PingResponse> getInfo(){
        return CHECK_HISTORY;
    }
}
