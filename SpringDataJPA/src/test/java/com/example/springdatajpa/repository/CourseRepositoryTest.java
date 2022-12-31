package com.example.springdatajpa.repository;

import com.example.springdatajpa.entity.Course;
import com.example.springdatajpa.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseRepositoryTest {

    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void fetchAllCourses(){
        List<Course> courses = courseRepository.findAll();
        System.out.println("courses = " + courses);

    }

    @Test
    public void saveCourseAndTeacher(){
        Teacher teacher = Teacher.builder()
                .firstName("Peace")
                .lastName("Obute")
                .build();

        Course course = Course.builder()
                .title("DSA")
                .credit(6)
                .teacher(teacher)
                .build();
    }
}