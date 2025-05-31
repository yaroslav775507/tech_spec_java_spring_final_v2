package org.example.tech_spec_java_spring_final_v2.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.tech_spec_java_spring_final_v2.model.Subscription;
import org.example.tech_spec_java_spring_final_v2.model.User;
import org.example.tech_spec_java_spring_final_v2.repository.SubscriptionRepository;
import org.example.tech_spec_java_spring_final_v2.repository.UserRepository;
import org.example.tech_spec_java_spring_final_v2.service.SubscriptionService;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class SubscriptionServiceImpl implements SubscriptionService {

    private final SubscriptionRepository subRepo;
    private final UserRepository userRepo;

    @Override
    public Subscription add(Long userId, Subscription subscription) {
        User user = userRepo.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        subscription.setUser(user);
        log.info("Adding subscription {}", subscription);
        return subRepo.save(subscription);
    }

    @Override
    public List<Subscription> getAll(Long userId) {
        log.info("Getting subscriptions for user {}", userId);
        return subRepo.findByUserId(userId);
    }

    @Override
    public void delete(Long userId, Long subId) {
        Subscription sub = subRepo.findById(subId).
                filter(subscription -> subscription.getUser().getId().equals(userId))
                .orElseThrow(() -> new RuntimeException("Subscription not found"));
        log.info("Deleting subscription {}", sub);
        subRepo.delete(sub);
    }

    @Override
    public List<String> getTop3() {
        log.info("Getting top 3 subscriptions");
        return subRepo.findTop3(PageRequest.of(0, 3));
    }
}
