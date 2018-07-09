package ru.mccarl.controlsystem.api.pinger.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.mccarl.controlsystem.api.dao.entity.InMemoryDb;
import ru.mccarl.controlsystem.api.dao.entity.PingResponse;
import ru.mccarl.controlsystem.api.pinger.Pinger;

import java.net.Socket;
import java.time.LocalDateTime;

@Component
public class PingerImpl implements Pinger {

    @Autowired
    private InMemoryDb inMemoryDb;

    @Override
    public void checkActiveServers() throws Exception {
        while (true) {
            Thread.sleep(Long.parseLong(inMemoryDb.getSettings().getSheduleTime()));
            inMemoryDb.getServers().forEach(server -> {
                try (Socket socket = new Socket(server.getUrl(), 80)) {
                    if (socket.isConnected()) {
                        inMemoryDb.savePingResponse(new PingResponse(server, "OK", LocalDateTime.now()));
                    } else {
                        inMemoryDb.savePingResponse(new PingResponse(server, "FAIL", LocalDateTime.now()));
                    }
                } catch (Exception ex) {
                    inMemoryDb.savePingResponse(new PingResponse(server, "FATAL", LocalDateTime.now(), ex.getMessage()));
                }
            });
        }
    }
}
