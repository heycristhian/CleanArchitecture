package br.com.heycristhian.cleanarchitecture.infrastructure.database.persistence.repository;


import br.com.heycristhian.cleanarchitecture.domain.model.User;
import br.com.heycristhian.cleanarchitecture.domain.repository.UserRepository;
import br.com.heycristhian.cleanarchitecture.infrastructure.database.persistence.springdata.UserJpaRepository;
import br.com.heycristhian.cleanarchitecture.infrastructure.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UserMysqlRepository implements UserRepository {

    private final UserJpaRepository userJpaRepository;
    private static final UserMapper userMapper = UserMapper.INSTANCE;

    @Override
    public Optional<User> findById(Long id) {
        return userJpaRepository.findById(id)
                .map(UserMapper.INSTANCE::toUser);
    }

    @Override
    public User save(User user) {
        var userSchema = userJpaRepository.save(userMapper.toUserSchema(user));
        return userMapper.toUser(userSchema);
    }
}
