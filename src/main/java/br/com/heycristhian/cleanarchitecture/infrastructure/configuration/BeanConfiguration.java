package br.com.heycristhian.cleanarchitecture.infrastructure.configuration;

import br.com.heycristhian.cleanarchitecture.domain.messaging.NotificationProducer;
import br.com.heycristhian.cleanarchitecture.domain.repository.UserRepository;
import br.com.heycristhian.cleanarchitecture.infrastructure.database.persistence.repository.UserMysqlRepository;
import br.com.heycristhian.cleanarchitecture.infrastructure.database.persistence.springdata.UserJpaRepository;
import br.com.heycristhian.cleanarchitecture.usecase.FindUser;
import br.com.heycristhian.cleanarchitecture.usecase.SaveUser;
import br.com.heycristhian.cleanarchitecture.usecase.ShowNotification;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

//    @Bean
//    public UserRepository userRepository(UserJpaRepository userJpaRepository) {
//        return new UserMysqlRepository(userJpaRepository);
//    }

    @Bean
    public FindUser findUser(UserRepository userRepository) {
        return new FindUser(userRepository);
    }

    @Bean
    public SaveUser saveUser(UserRepository userRepository, NotificationProducer notificationProducer) {
        return new SaveUser(userRepository, notificationProducer);
    }

    @Bean
    public ShowNotification showNotification() {
        return new ShowNotification();
    }
}
