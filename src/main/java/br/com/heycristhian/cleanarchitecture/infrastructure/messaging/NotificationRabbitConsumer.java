package br.com.heycristhian.cleanarchitecture.infrastructure.messaging;

import br.com.heycristhian.cleanarchitecture.usecase.ShowNotification;
import org.springframework.stereotype.Component;

@Component
public class NotificationRabbitConsumer {

    private final ShowNotification showNotification;

    public NotificationRabbitConsumer(ShowNotification showNotification) {
        this.showNotification = showNotification;
    }

    public void listener(String message) {
        showNotification.execute(message);
    }
}
