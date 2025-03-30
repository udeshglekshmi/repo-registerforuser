package com.app.register.repository;

import com.app.register.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository extends JpaRepository<UserModel, Long>{

	Optional<UserModel> findByEmail(String email);

	boolean existsByEmail(String email);

}

