package br.com.heycristhian.cleanarchitecture.infrastructure.messaging;

import br.com.heycristhian.cleanarchitecture.domain.messaging.NotificationProducer;
import org.springframework.stereotype.Component;

@Component
public class NotificationRabbitProducer implements NotificationProducer {

    @Override
    public void sendMessage(String message) {
        System.out.println("Message sent: " + message);
    }
}
