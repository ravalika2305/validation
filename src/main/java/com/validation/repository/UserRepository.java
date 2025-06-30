package com.validation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.validation.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
