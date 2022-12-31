package com.example.springdatajpa.repository;

import com.example.springdatajpa.entity.Guardian;
import com.example.springdatajpa.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentRepositoryTest {

    @Autowired
   private StudentRepository studentRepository;



    @Test
    public void saveStudent(){
        Student student = Student.builder()
                .emailId("devs@gmail.com")
                .firstName("Devs")
                .lastName("Devi")
                //.guardianName("Dov")
               // .guardianEmail("dov@gmail.com")
               // .guardianMobile("55555555")
                .build();

        studentRepository.save(student);
    }
@Test
    public void saveStudentWithGuardian(){
        Guardian guardian = Guardian.builder()
                .name("Dov")
                .email("dov@gmail.com")
                .mobile("55555555")
                .build();

        Student student = Student.builder()
                .emailId("devs@gmail.com")
                .firstName("Devs")
                .lastName("Devi")
                .guardian(guardian)
                .build();
studentRepository.save(student);
    }

    @Test
    public void printAllStudents(){
        List<Student> studentList = studentRepository.findAll();
        //System.out.println(studentList);
        System.out.println("studentList = " + studentList);
    }

    @Test
    public void printStudentByFirstName(){
       // List<Student> studentsFirstName = studentRepository.findByFirstName("Devs");
        List<Student> students = studentRepository.findByFirstName("Devs");
        System.out.println("students = " + students);
    }
    
    @Test
    public void printStudentByFirstCaharcters(){
        List<Student> list = studentRepository.findByFirstNameContaining("De");
        System.out.println("list = " + list);
    }

    @Test
    public void printStudentByFirstNameAndLastName(){
       Student doubleList = studentRepository.findByFirstNameAndLastName("Devs", "Devi");
        System.out.println("doubleList = " + doubleList);
    }

    @Test
    public void printStudentByGuardianName(){
        List<Student> guardianList = studentRepository.findByGuardianName("Dov");
        System.out.println("guardianList = " + guardianList);
    }
    
    @Test
    public void printGetStudentFirstNameByEmailAddress(){
        String firstName = studentRepository.getStudentFirstNameByEmailAddress("devs@gmail.com");
        System.out.println("firstName = " + firstName);
    }

    @Test
    public void printGetStudentByEmailAddress(){
        Student studentslists = studentRepository.getStudentByEmailAddressNative("devs@gmail.com");
        System.out.println("studentslists = " + studentslists);
    }

    @Test
    public void printGetStudentByEmailAddressNativeParams(){
        Student studentByEmail = studentRepository.getStudentByEmailAddressNativeParam("devs@gmail.com");
        System.out.println("studentByEmail = " + studentByEmail);
    }

    @Test
    public void printUpdateStudentNameByEmailId(){
         studentRepository.updateStudentNameByEmailId(
                "peace",
                "dov@gmail.com"
        );
    }
}