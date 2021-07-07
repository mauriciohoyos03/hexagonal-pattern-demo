package com.mauricio.adapter_pattern.domain.repository;

import com.mauricio.adapter_pattern.domain.model.User;

import java.util.List;

public interface UserRepository {

    List<User> findAllUser();
}
