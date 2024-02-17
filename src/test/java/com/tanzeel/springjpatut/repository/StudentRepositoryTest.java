package com.tanzeel.springjpatut.repository;

import com.tanzeel.springjpatut.entity.Guardian;
import com.tanzeel.springjpatut.entity.Student;
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
    public void saveStudent() {
        Student student = Student.builder()
                .firstName("Dred")
                .lastName("Phil")
                .email("john2@gmail.com")
//                .guardianName("Peter")
//                .guardianEmail("peter@gmail.com")
//                .guardianNumber("122233344455")
                .build();
        studentRepository.save(student);
    }

    @Test
    public void testStudentWithGuardian() {
        Guardian guardian = Guardian.builder()
                .name("Kelpos")
                .email("kenneth@gmail.com")
                .mobile("1234569874")
                .build();

        Student student = Student.builder()
                .firstName("Md")
                .lastName("Sajid")
                .email("k2@gmail.com")
                .guardian(guardian)
                .build();

        studentRepository.save(student);

    }

    @Test
    public void printAllStudents() {
        List<Student> students = studentRepository.findAll();
        System.out.println("Student: " + students);
    }

    @Test
    public void deleteStudent() {
        Long studentId = 52L;
        if (studentRepository.existsById(studentId)) {
            studentRepository.deleteById(studentId);
        }
    }

    @Test
    public void findAllStudentsByFirstName() {
        List<Student> students = studentRepository.findByFirstName("Md");
        System.out.println("Student: " + students);
    }


}