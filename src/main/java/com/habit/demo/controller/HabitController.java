package com.habit.demo.controller;

import com.habit.demo.model.Habit;
import com.habit.demo.repository.HabitRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/habits")
public class HabitController {

    private final HabitRepository habitRepository;

    public HabitController(HabitRepository habitRepository) {
        this.habitRepository = habitRepository;
    }

    @PostMapping
    void create(@RequestBody CreateHabitRequest request){

        Habit h=new Habit();
        h.setName(request.name());
        this.habitRepository.save(h);

    }
}
