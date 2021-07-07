package com.mauricio.adapter_pattern.domain;

import com.mauricio.adapter_pattern.domain.cache.CacheRepository;
import com.mauricio.adapter_pattern.domain.model.User;
import com.mauricio.adapter_pattern.domain.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import java.util.*;

@ExtendWith(SpringExtension.class)
public class UserServiceTest {

    @InjectMocks
    UserService userService;

    @Mock
    UserRepository userRepository;

    @Mock
    CacheRepository cacheRepository;

    @Test
    @DisplayName("Check getAllUsers method in UserService")
    public void shouldReturnListUsers() {
        Mockito.when(userRepository.findAllUser()).thenReturn(getUsers());
        Mockito.when(cacheRepository.getUserCategories()).thenReturn(getCategories());

        List<User> users = userService.getAllUsers();

        Assertions.assertNotNull(users);
        Assertions.assertTrue(users.size() > 0);
        Mockito.verify(userRepository).findAllUser();
    }

    private Map<String, String> getCategories() {
        Map<String, String> userTypes = new HashMap<>();
        userTypes.put("1", "Developer");
        userTypes.put("2", "QA");

        return userTypes;
    }

    private List<User> getUsers() {
        List<User> users = new ArrayList<>();

        User user1 = new User();
        user1.setName("Mauro");
        user1.setLastName("Hoyos");
        user1.setAge(29);
        user1.setIdUserType("1");

        users.add(user1);

        User user2 = new User();
        user2.setName("Dante");
        user2.setAge(1);
        user2.setIdUserType("2");

        users.add(user2);

        return users;
    }
}
