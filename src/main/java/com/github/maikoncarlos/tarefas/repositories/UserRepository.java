package com.github.maikoncarlos.tarefas.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.github.maikoncarlos.tarefas.entities.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, UUID>{

	Optional<UserEntity> findByEmail(String email);
}
