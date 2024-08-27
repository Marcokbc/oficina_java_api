package com.example.demo.service;

import com.example.demo.domain.User;
import com.example.demo.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public List<User> listAll(){
        return userRepository.findAll();
    }

    public User findById(long id){
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Aluno not Found"));
    }

    @Transactional
    public User save(User user) {
        return userRepository.save(user);
    }

    public void delete(long id) {
        userRepository.delete(findById(id));
    }

    public void replace(User userPutRequest) {
        User savedUser = findById(userPutRequest.getId());
        User user = User.builder()
                .id(savedUser.getId())
                .name(userPutRequest.getName())
                .age(userPutRequest.getAge())
                .login(userPutRequest.getLogin())
                .password(userPutRequest.getPassword())
                .build();

        userRepository.save(user);

    }
}
