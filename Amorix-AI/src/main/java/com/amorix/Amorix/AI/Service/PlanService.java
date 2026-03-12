package com.amorix.Amorix.AI.Service;

import com.amorix.Amorix.AI.Dto.Plan.Response.PlanResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface PlanService {
    List<PlanResponseDto> getAllPlans();


}
