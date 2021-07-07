package com.mauricio.adapter_pattern.adapter.h2db_repository;

import com.mauricio.adapter_pattern.adapter.h2db_repository.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface H2RepoUser extends JpaRepository<UserEntity, String> {

}
