package com.app.Taskman;

import com.app.Taskman.Task;
import com.app.Taskman.TaskRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class TaskController {
    private final TaskRepository taskRepository;

    public TaskController(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    // Displaying list of tasks
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("tasks", taskRepository.findAll());
        return "index";
    }

    // show form for a new task
    @GetMapping("/add")
    public String addTaskForm(Model model) {
        model.addAttribute("task", new Task());
        return "addTask";
    }

    // process new task submission
    @PostMapping("/add")
    public String addTaskSubmit(@ModelAttribute Task task) {
        taskRepository.save(task);
        return "redirect:/";
    }
}

