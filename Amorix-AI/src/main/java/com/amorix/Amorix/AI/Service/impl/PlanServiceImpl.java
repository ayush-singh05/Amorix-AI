package com.amorix.Amorix.AI.Service.impl;

import com.amorix.Amorix.AI.Dto.Plan.Response.PlanResponseDto;
import com.amorix.Amorix.AI.Service.PlanService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlanServiceImpl implements PlanService {

    @Override
    public List<PlanResponseDto> getAllPlans() {

        return List.of();
    }

    @Override
    public List<PlanResponseDto> getAllActivePlanS() {
        return List.of();
    }
}
