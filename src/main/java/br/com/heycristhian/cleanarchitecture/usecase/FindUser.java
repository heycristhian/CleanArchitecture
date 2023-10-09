package br.com.heycristhian.cleanarchitecture.usecase;


import br.com.heycristhian.cleanarchitecture.domain.exception.ObjectNotFoundException;
import br.com.heycristhian.cleanarchitecture.domain.model.User;
import br.com.heycristhian.cleanarchitecture.domain.repository.UserRepository;

public class FindUser {

    private final UserRepository userRepository;

    public FindUser(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User execute(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Object not found with id: " + id));
    }
}
