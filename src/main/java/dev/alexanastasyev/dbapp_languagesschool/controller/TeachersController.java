package dev.alexanastasyev.dbapp_languagesschool.controller;

import dev.alexanastasyev.dbapp_languagesschool.dto.TeacherDto;
import dev.alexanastasyev.dbapp_languagesschool.exception.InvalidValuesException;
import dev.alexanastasyev.dbapp_languagesschool.model.Teacher;
import dev.alexanastasyev.dbapp_languagesschool.service.teacher.TeachersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/teachers")
public class TeachersController {

    private final TeachersService teachersService;

    @Autowired
    public TeachersController(TeachersService teachersService) {
        this.teachersService = teachersService;
    }

    @GetMapping
    public List<Teacher> showAllTeachers() {
        return teachersService.getAllTeachers();
    }

    @PostMapping
    public void addTeacher(@RequestBody TeacherDto teacherDto) {
        Teacher teacher = new Teacher(0, teacherDto.getFirstname(), teacherDto.getLastname(), Optional.of(teacherDto.getPatronymic()));
        try {
            teachersService.addTeacher(teacher);
        } catch (InvalidValuesException e) {
            System.out.println(e.getMessage());
        }
    }
}
