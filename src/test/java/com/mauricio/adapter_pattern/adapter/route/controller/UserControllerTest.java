package com.mauricio.adapter_pattern.adapter.route.controller;

import com.mauricio.adapter_pattern.domain.UserService;
import com.mauricio.adapter_pattern.domain.model.User;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import java.util.ArrayList;
import java.util.List;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = UserController.class)
class UserControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    UserService userService;

    @Test
    public void shouldReturnStatusOK() throws Exception {

        Mockito.when(userService.getAllUsers()).thenReturn(getUsers());

        mockMvc.perform(get("/api/v1/user").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[:1].name").exists())
                .andExpect(jsonPath("$[:1].age").isNotEmpty());
    }

    @Test
    public void shouldReturnNotFoundHttpCode() throws Exception{
        mockMvc.perform(post("/api/v1/user"))
                .andExpect(status().isMethodNotAllowed());
    }

    private List<User> getUsers() {
        List<User> users = new ArrayList<>();

        User user1 = new User();
        user1.setName("Mauro");
        user1.setLastName("Hoyos");
        user1.setAge(29);
        user1.setIdUserType("1");
        user1.setUserType("Developer");

        users.add(user1);

        User user2 = new User();
        user2.setName("Dante");
        user2.setAge(1);
        user2.setIdUserType("2");
        user2.setUserType("QA");

        users.add(user2);

        return users;
    }
}