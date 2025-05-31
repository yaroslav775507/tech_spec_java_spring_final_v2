package org.example.tech_spec_java_spring_final_v2.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.tech_spec_java_spring_final_v2.model.User;
import org.example.tech_spec_java_spring_final_v2.repository.UserRepository;
import org.example.tech_spec_java_spring_final_v2.service.UserService;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepo;

    @Override
    public User create(User user) {
        log.info("Creating user {}", user);
        return userRepo.save(user);
    }

    @Override
    public User getInfo(Long id) {
        log.info("Retrieving user {}", id);
        return userRepo.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
    }

    @Override
    public User update(Long id, User updatedUser) {
        User user = getInfo(id);
        user.setName(updatedUser.getName());
        user.setNickname(updatedUser.getNickname());
        log.info("Updating user {}", user);
        return userRepo.save(user);
    }

    @Override
    public void delete(Long id) {
        log.info("Deleting user {}", id);
        userRepo.deleteById(id);
    }
}
