package com.example.PlannerStudies.repository;

import com.example.PlannerStudies.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Long, Task> {

}
