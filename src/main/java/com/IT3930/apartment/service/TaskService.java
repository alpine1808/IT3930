package com.IT3930.apartment.service;

import com.IT3930.apartment.model.Task;
import com.IT3930.apartment.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public List<Task> getTasksByStaff(Long staffId) {
        return taskRepository.findByStaffIdOrderByIdAsc(staffId);
    }
}
