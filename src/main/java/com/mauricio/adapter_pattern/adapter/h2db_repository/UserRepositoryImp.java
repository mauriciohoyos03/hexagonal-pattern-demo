package com.mauricio.adapter_pattern.adapter.h2db_repository;

import com.mauricio.adapter_pattern.domain.model.User;
import com.mauricio.adapter_pattern.domain.repository.UserRepository;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserRepositoryImp implements UserRepository {

    H2RepoUser h2RepoUser;

    @Autowired
    public UserRepositoryImp(H2RepoUser h2RepoUser) {
        this.h2RepoUser = h2RepoUser;
    }

    @Override
    public List<User> findAllUser() {

        return h2RepoUser.findAll().stream()
                .map(userEntity -> new User(userEntity.getFirstName(), userEntity.getLastName(), userEntity.getAge()))
                .collect(Collectors.toList());
    }
}