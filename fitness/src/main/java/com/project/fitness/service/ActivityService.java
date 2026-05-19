package com.project.fitness.service;

import com.project.fitness.dto.ActivityRequest;
import com.project.fitness.dto.ActivityResponse;
import com.project.fitness.model.Activity;
import com.project.fitness.model.User;
import com.project.fitness.repository.ActivityRepository;
import com.project.fitness.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ActivityService
{
    private final ActivityRepository activityRepository;
    private final UserRepository userRepository;

    public ActivityResponse trackActivity(ActivityRequest activityRequest)
    {
        if(activityRequest.getUserId() == null)
        {
            throw new RuntimeException("User ID is required");
        }
        User user=userRepository.findById(activityRequest.getUserId())
                .orElseThrow(()->new RuntimeException("Invaluid user :"+activityRequest.getUserId()));
        Activity activity= Activity.builder()
                .user(user)
                .type(activityRequest.getType())
                .duration(activityRequest.getDuration())
                .caloriesBurned(activityRequest.getCaloriesBurned())
                .startTime(activityRequest.getStartTime())
                .additionalMetrics(activityRequest.getAdditionalMetrics())
                .build();
       Activity saveActivity = activityRepository.save(activity);
       return  mapToResponse(saveActivity);


    }

    private ActivityResponse mapToResponse(Activity saveActivity)
    {
        ActivityResponse response=new ActivityResponse();
        response.setId(saveActivity.getId());
        response.setUserId(saveActivity.getUser().getId());
        response.setType(saveActivity.getType());
        response.setDuration(saveActivity.getDuration());
        response.setCaloriesBurned(saveActivity.getCaloriesBurned());
        response.setStartTime(saveActivity.getStartTime());
        response.setAdditionalMetrics(saveActivity.getAdditionalMetrics());
        response.setCreateAt(saveActivity.getCreateAt());
        response.setUpdateAt(saveActivity.getUpdateAt());
        return  response;
    }


    public List<ActivityResponse> getUserActivityTrack(String userId)
    {
        List<Activity> activityList=activityRepository.findByUserId(userId);
        return activityList.stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }
}
