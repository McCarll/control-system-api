package ru.mccarl.controlsystem.api.pinger;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;


@Slf4j
@Component
public class PingerController {

    @Autowired
    private Pinger pinger;

    private static Thread pingThread;

    @PostConstruct
    public void init() {
        pingThread = new Thread(() -> {
            try {
                pinger.checkActiveServers();
            } catch (Exception e) {
                log.error(e.getMessage());
            }
        });
        pingThread.start();
    }

    public void restartPinger() {
        try {
            pingThread.stop();
            pingThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        init();
    }

}
