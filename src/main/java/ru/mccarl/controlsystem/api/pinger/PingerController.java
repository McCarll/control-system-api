package ru.mccarl.controlsystem.api.pinger;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import ru.mccarl.controlsystem.api.pinger.impl.PingerImpl;


@Slf4j
@Component
public class PingerController {

    private static Thread pingThread;

    public static void init() {
        pingThread = new Thread(() -> {
            PingerImpl pinger = new PingerImpl();
            try {
                pinger.checkActiveServers();
            } catch (Exception e) {
                log.error(e.getMessage());
            }
        });
        pingThread.start();
    }

    public void restartPinger() {
        pingThread.interrupt();
        pingThread.start();
    }

}
