package br.com.heycristhian.cleanarchitecture.infrastructure.http.controller;

import br.com.heycristhian.cleanarchitecture.infrastructure.http.dto.request.UserRequest;
import br.com.heycristhian.cleanarchitecture.infrastructure.http.dto.response.UserResponse;
import br.com.heycristhian.cleanarchitecture.infrastructure.mapper.UserMapper;
import br.com.heycristhian.cleanarchitecture.infrastructure.messaging.NotificationRabbitConsumer;
import br.com.heycristhian.cleanarchitecture.usecase.FindUser;
import br.com.heycristhian.cleanarchitecture.usecase.SaveUser;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public class UserController {

    private final SaveUser saveUser;
    private final FindUser findUser;
    private final NotificationRabbitConsumer notificationRabbitConsumer;

    @PostMapping
    public ResponseEntity<UserResponse> save(@RequestBody UserRequest userRequest, UriComponentsBuilder uriBuilder) {
        var user = UserMapper.INSTANCE.toUser(userRequest);
        var userResponse = UserMapper.INSTANCE.toUserResponse(saveUser.execute(user));

        URI uri = uriBuilder.path("/api/v1/users/{id}").buildAndExpand(userResponse.getId()).toUri();

        return ResponseEntity.created(uri).body(userResponse);
    }

    @GetMapping("{id}")
    public ResponseEntity<UserResponse> findById(@PathVariable Long id) {
        var userResponse = UserMapper.INSTANCE.toUserResponse(
                findUser.execute(id)
        );

        return ResponseEntity.ok(userResponse);
    }

    @PostMapping("/messageConsumerSimulation")
    public ResponseEntity<Void> consumeMessage(@RequestBody String message) {
        notificationRabbitConsumer.listener(message);
        return ResponseEntity.ok().build();
    }

}
