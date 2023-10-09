package br.com.heycristhian.cleanarchitecture.infrastructure.database.persistence.springdata;

import br.com.heycristhian.cleanarchitecture.infrastructure.database.schema.UserSchema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserJpaRepository extends JpaRepository<UserSchema, Long> {
}
