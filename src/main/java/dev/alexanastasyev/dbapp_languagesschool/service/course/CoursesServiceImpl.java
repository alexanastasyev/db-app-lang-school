package dev.alexanastasyev.dbapp_languagesschool.service.course;

import dev.alexanastasyev.dbapp_languagesschool.model.Course;
import dev.alexanastasyev.dbapp_languagesschool.repository.course.CoursesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoursesServiceImpl implements CoursesService {

    private final CoursesRepository coursesRepository;

    @Autowired
    public CoursesServiceImpl(CoursesRepository coursesRepository) {
        this.coursesRepository = coursesRepository;
    }

    @Override
    public List<Course> getAllCourses() {
        return coursesRepository.findAll();
    }

    @Override
    public List<Course> getByName(String name) {
        return coursesRepository.findByName(name);
    }


}
