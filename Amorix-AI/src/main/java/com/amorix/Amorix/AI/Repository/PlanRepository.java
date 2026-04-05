package com.amorix.Amorix.AI.Repository;

import aj.org.objectweb.asm.commons.Remapper;
import com.amorix.Amorix.AI.Entity.Plan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PlanRepository extends JpaRepository<Plan, Long> {
    Optional<Plan> findByStripePriceId(String id);
}
