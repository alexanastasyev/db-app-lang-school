package dev.alexanastasyev.dbapp_languagesschool.service.teacher;

import dev.alexanastasyev.dbapp_languagesschool.exception.InvalidValuesException;
import dev.alexanastasyev.dbapp_languagesschool.model.Teacher;
import dev.alexanastasyev.dbapp_languagesschool.repository.teacher.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeachersServiceImpl implements TeachersService{

    private final TeacherRepository teacherRepository;

    @Autowired
    public TeachersServiceImpl(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @Override
    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }

    @Override
    public void addTeacher(Teacher teacher) {
        if (teacher.getFirstname().isEmpty() || teacher.getLastname().isEmpty()) {
            throw new InvalidValuesException("Invalid values for adding teacher");
        }
        teacherRepository.add(teacher);
    }
}
