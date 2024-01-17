package com.habit.demo.repository;

import com.habit.demo.model.Habit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HabitRepository extends JpaRepository<Habit,Integer> {

}
