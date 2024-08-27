package com.example.demo;

import com.example.demo.domain.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Test
    public void findUserById_shouldBeReturnUserWhenExists() {
        User usuario = new User(990L,"João", 18, "isaohdaosd", "jhasdhasd");
        when(userRepository.findById(990L)).thenReturn(Optional.of(usuario));

        User results = userService.findById(990L);

        assertEquals("João", results.getName());
        assertEquals(990L, results.getId());
    }

}
