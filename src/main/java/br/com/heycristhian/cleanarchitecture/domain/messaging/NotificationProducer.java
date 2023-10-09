package br.com.heycristhian.cleanarchitecture.domain.messaging;

public interface NotificationProducer {
    void sendMessage(String message);
}
