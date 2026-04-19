package com.amorix.Amorix.AI.Repository;

import com.amorix.Amorix.AI.Entity.Subscription;
import com.amorix.Amorix.AI.Enum.SubscriptionStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.Set;

public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {
    Optional<Subscription> findByUserIdAndStatusIn(Long userId, Set<SubscriptionStatus> active);

    Optional<Subscription> findByStripeSubscriptionId(String gatewaySubscriptionId);

    boolean existsByStripeSubscriptionId(String subscriptionId);
}
