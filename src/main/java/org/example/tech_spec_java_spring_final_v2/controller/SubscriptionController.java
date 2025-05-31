package org.example.tech_spec_java_spring_final_v2.controller;

import lombok.RequiredArgsConstructor;
import org.example.tech_spec_java_spring_final_v2.model.Subscription;
import org.example.tech_spec_java_spring_final_v2.service.SubscriptionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users/{userId}/subscriptions")
@RequiredArgsConstructor
public class SubscriptionController {

    private final SubscriptionService subscriptionService;

    @PostMapping("/create")
    public ResponseEntity<Subscription> create(
            @PathVariable Long userId,
            @RequestBody Subscription subscription) {
        return ResponseEntity.ok(subscriptionService.add(userId, subscription));
    }

    @GetMapping("/all")
    public ResponseEntity<List<Subscription>> getAll(@PathVariable Long userId) {
        return ResponseEntity.ok(subscriptionService.getAll(userId));
    }

    @DeleteMapping("/{subId}")
    public ResponseEntity<Void> delete(
            @PathVariable Long userId,
            @PathVariable Long subId) {
        subscriptionService.delete(userId, subId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/top")
    public ResponseEntity<List<String>> top() {
        return ResponseEntity.ok(subscriptionService.getTop3());
    }
}
