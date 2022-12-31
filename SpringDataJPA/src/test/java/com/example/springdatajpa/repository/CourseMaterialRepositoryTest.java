package com.example.springdatajpa.repository;

import com.example.springdatajpa.entity.Course;
import com.example.springdatajpa.entity.CourseMaterial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseMaterialRepositoryTest {

    @Autowired
    private CourseMaterialRepository courseMaterialRepository;

    @Test
    public void saveCourseMaterial(){
    Course course = Course.builder()
            .title("Advanced Mechatronics")
            .credit(3)
            .build();

    CourseMaterial courseMaterial = CourseMaterial.builder()
            .url("www.blah.com")
            .course(course)
            .build();

    courseMaterialRepository.save(courseMaterial);
    }

    @Test
    public void fetchAllMaterials(){
        List<CourseMaterial> materials=  courseMaterialRepository.findAll();
        System.out.println("materials = " + materials);
    }

}