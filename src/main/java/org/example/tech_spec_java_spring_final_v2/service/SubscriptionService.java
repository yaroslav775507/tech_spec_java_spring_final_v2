package org.example.tech_spec_java_spring_final_v2.service;

import org.example.tech_spec_java_spring_final_v2.model.Subscription;

import java.util.List;

public interface SubscriptionService {
    Subscription add(Long userId, Subscription subscription);

    List<Subscription> getAll(Long userId);

    void delete(Long userId, Long subId);

    List<String> getTop3();
}

