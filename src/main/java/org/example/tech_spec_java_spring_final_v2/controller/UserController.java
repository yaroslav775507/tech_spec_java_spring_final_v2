package org.example.tech_spec_java_spring_final_v2.controller;

import lombok.RequiredArgsConstructor;
import org.example.tech_spec_java_spring_final_v2.model.User;
import org.example.tech_spec_java_spring_final_v2.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/create")
    public ResponseEntity<User> create(@RequestBody User user) {
        return ResponseEntity.ok(userService.create(user));
    }

    @GetMapping("get/{userId}")
    public ResponseEntity<User> getInfo(@PathVariable Long userId) {
        return ResponseEntity.ok(userService.getInfo(userId));
    }

    @PutMapping("/update/{userId}")
    public ResponseEntity<User> update(@PathVariable Long userId, @RequestBody User user) {
        return ResponseEntity.ok(userService.update(userId, user));
    }

    @DeleteMapping("delete/{userId}")
    public ResponseEntity<Void> delete(@PathVariable Long userId) {
        userService.delete(userId);
        return ResponseEntity.noContent().build();
    }

}
