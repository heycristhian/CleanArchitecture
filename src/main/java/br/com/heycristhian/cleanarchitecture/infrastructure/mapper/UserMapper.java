package br.com.heycristhian.cleanarchitecture.infrastructure.mapper;

import br.com.heycristhian.cleanarchitecture.domain.model.User;
import br.com.heycristhian.cleanarchitecture.infrastructure.database.schema.UserSchema;
import br.com.heycristhian.cleanarchitecture.infrastructure.http.dto.request.UserRequest;
import br.com.heycristhian.cleanarchitecture.infrastructure.http.dto.response.UserResponse;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    User toUser(UserRequest userRequest);

    UserResponse toUserResponse(User user);

    User toUser(UserSchema userSchema);

    UserSchema toUserSchema(User user);
}
