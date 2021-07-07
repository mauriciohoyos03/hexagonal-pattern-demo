package com.mauricio.adapter_pattern.adapter.h2db_repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mauricio.adapter_pattern.adapter.h2db_repository.entity.UserEntity;
import com.mauricio.adapter_pattern.domain.model.User;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import java.io.File;
import java.io.IOException;
import java.util.List;

@ExtendWith(SpringExtension.class)
class UserRepositoryImpTest {

    private static final String USERS_DATA_DUMMIES = "src/test/resources/user_entities.json";

    @InjectMocks
    UserRepositoryImp userRepository;

    @Mock
    H2RepoUser h2RepoUser;

    private final ObjectMapper mapper;

    public UserRepositoryImpTest () {
        mapper = new ObjectMapper();
    }

    @Test
    @DisplayName("Should return a empty list of Users")
    public void shouldReturnEmptyUserList() {

        List<User> userEntities = userRepository.findAllUser();

        Assertions.assertNotNull(userEntities);
        Assertions.assertTrue(userEntities.size() < 1);
    }

    @Test
    @DisplayName("Should return a list of users")
    public void shouldReturnUsersList() throws IOException {

        List<UserEntity> userEntities = mapper.readValue(new File(USERS_DATA_DUMMIES),
                new TypeReference<List<UserEntity>>() {});
        Mockito.when(h2RepoUser.findAll()).thenReturn(userEntities);

        List<User> users = userRepository.findAllUser();

        Assertions.assertNotNull(users);
        Assertions.assertFalse(users.isEmpty());
        Assertions.assertTrue(users.size() > 1);
        Assertions.assertNotNull(users.get(0).getName());
    }
}