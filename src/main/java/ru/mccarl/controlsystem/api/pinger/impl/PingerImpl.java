package ru.mccarl.controlsystem.api.pinger.impl;

import org.springframework.beans.factory.annotation.Autowired;
import ru.mccarl.controlsystem.api.dao.entity.InMemoryDb;
import ru.mccarl.controlsystem.api.dao.entity.PingResponse;
import ru.mccarl.controlsystem.api.pinger.Pinger;

import java.net.Socket;
import java.time.LocalDateTime;

public class PingerImpl implements Pinger {

    @Autowired
    private InMemoryDb inMemoryDb;

    @Override
    public void checkActiveServers() throws Exception {
        while (true) {
            System.out.println("\n\n====THIS IS NEW PING THREAD=====\n\n");
            if (inMemoryDb != null) {
                Thread.sleep(Long.getLong(inMemoryDb.getSettings().getSheduleTime()));
                inMemoryDb.getServers().forEach(server -> {
                    try (Socket socket = new Socket(server.getUrl(), 80)) {
                        if (socket.isConnected()) {
                            inMemoryDb.savePingResponse(new PingResponse("OK", LocalDateTime.now()));
                        } else {
                            inMemoryDb.savePingResponse(new PingResponse("FAIL", LocalDateTime.now()));
                        }
                    } catch (Exception ex) {
                        inMemoryDb.savePingResponse(new PingResponse("FATAL", LocalDateTime.now(), ex.getMessage()));
                    }
                });
            } else {
                Thread.sleep(2000);
            }
        }
    }
}
