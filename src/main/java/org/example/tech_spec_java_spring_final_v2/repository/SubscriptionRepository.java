package org.example.tech_spec_java_spring_final_v2.repository;

import org.example.tech_spec_java_spring_final_v2.model.Subscription;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {
    List<Subscription> findByUserId(Long userId);

    @Query("SELECT s.title from Subscription s group by s.title order by count(s) desc")
    List<String> findTop3(Pageable pageable);

}
