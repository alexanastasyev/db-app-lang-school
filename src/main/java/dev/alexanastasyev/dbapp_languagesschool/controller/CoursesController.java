package dev.alexanastasyev.dbapp_languagesschool.controller;

import dev.alexanastasyev.dbapp_languagesschool.model.Course;
import dev.alexanastasyev.dbapp_languagesschool.service.course.CoursesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CoursesController {

    private final CoursesService coursesService;

    @Autowired
    public CoursesController(CoursesService coursesService) {
        this.coursesService = coursesService;
    }

    @GetMapping
    public List<Course> showAllCourses() {
        return coursesService.getAllCourses();
    }

}
