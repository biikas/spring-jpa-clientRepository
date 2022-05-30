package com.bikash.springjpa.crud.student;

import com.bikash.springjpa.model.Student;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class StudentMapper {
    public Student convertToStudent(StudentRequest studentRequest){
        Student student = new Student();
        student.setActive('Y');
        student.setAddress(studentRequest.getAddress());
        student.setContactNumber(studentRequest.getContactNumber());
        student.setAddress(studentRequest.getAddress());
        student.setEmail(studentRequest.getEmail());
        student.setFirstName(studentRequest.getFirstName());
        student.setLastName(studentRequest.getLastName());
        student.setSubject(studentRequest.getSubjectName());
        student.setJoinDate(new Date());
        return student;
    }

    public Student convertToModifyStudent(Student student,StudentRequest studentRequest){
        student.setActive(studentRequest.getActive());
        student.setAddress(studentRequest.getAddress());
        student.setContactNumber(studentRequest.getContactNumber());
        student.setAddress(studentRequest.getAddress());
        student.setEmail(studentRequest.getEmail());
        student.setFirstName(studentRequest.getFirstName());
        student.setLastName(studentRequest.getLastName());
        student.setSubject(studentRequest.getSubjectName());
        student.setJoinDate(student.getJoinDate());
        return student;
    }

}
