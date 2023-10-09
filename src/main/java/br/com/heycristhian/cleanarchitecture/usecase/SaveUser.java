package br.com.heycristhian.cleanarchitecture.usecase;


import br.com.heycristhian.cleanarchitecture.domain.messaging.NotificationProducer;
import br.com.heycristhian.cleanarchitecture.domain.model.User;
import br.com.heycristhian.cleanarchitecture.domain.repository.UserRepository;

public class SaveUser {

    private final UserRepository userRepository;
    private final NotificationProducer notificationProducer;

    public SaveUser(UserRepository userRepository, NotificationProducer notificationProducer) {
        this.userRepository = userRepository;
        this.notificationProducer = notificationProducer;
    }

    public User execute(User user) {
        var savedUser = userRepository.save(user);
        notificationProducer.sendMessage(String.valueOf(savedUser));

        return savedUser;
    }
}
