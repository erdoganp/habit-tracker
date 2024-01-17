package com.habit.demo.controller;

import com.habit.demo.model.Activity;
import com.habit.demo.model.Habit;
import com.habit.demo.repository.ActivityRepository;
import com.habit.demo.repository.HabitRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/activities")
public class ActivityController {

    private final ActivityRepository activityRepository;

    private final HabitRepository habitRepository;

    public ActivityController(ActivityRepository activityRepository, HabitRepository habitRepository) {
        this.activityRepository = activityRepository;
        this.habitRepository = habitRepository;
    }

    @PostMapping()
    void create(@RequestBody CreateActivityRequest request){
        Habit habit=this.habitRepository.findById(request.habitid()).orElseThrow(EntityNotFoundException::new);
        Activity activity=new Activity();
        activity.setHabit(habit);
        this.activityRepository.save(activity);
    }
}
