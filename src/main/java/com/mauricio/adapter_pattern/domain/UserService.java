package com.mauricio.adapter_pattern.domain;

import com.mauricio.adapter_pattern.domain.cache.CacheRepository;
import com.mauricio.adapter_pattern.domain.model.User;
import com.mauricio.adapter_pattern.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final CacheRepository cacheRepository;

    @Autowired
    public UserService(UserRepository repository, CacheRepository cacheRepository) {
        this.userRepository = repository;
        this.cacheRepository = cacheRepository;
    }

    public List<User> getAllUsers() {

        List<User> listUsers = userRepository.findAllUser();

        Map<String, String> userCategories = cacheRepository.getUserCategories();

        //Map category for each user
        listUsers.forEach(user -> {
            user.setUserType(userCategories.get(user.getIdUserType()));
        });

        return listUsers;
    }
}
