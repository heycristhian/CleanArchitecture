package br.com.heycristhian.cleanarchitecture.domain.repository;


import br.com.heycristhian.cleanarchitecture.domain.model.User;

import java.util.Optional;

public interface UserRepository {
    Optional<User> findById(final Long id);
    User save(User user);
}
