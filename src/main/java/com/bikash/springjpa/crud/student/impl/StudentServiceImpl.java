package com.bikash.springjpa.crud.student.impl;


import com.bikash.springjpa.crud.student.StudentMapper;
import com.bikash.springjpa.crud.student.StudentRequest;
import com.bikash.springjpa.crud.student.StudentService;
import com.bikash.springjpa.model.Student;
import com.bikash.springjpa.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public boolean createStudent(StudentRequest studentRequest) {
        Student student =studentMapper.convertToStudent(studentRequest);
        studentRepository.save(student);
        return true;
    }

    @Override
    public boolean modifyStudent(StudentRequest studentRequest, int id) {
        Student student = studentRepository.findStudentById(id);
        student =studentMapper.convertToModifyStudent(student,studentRequest);
        studentRepository.save(student);
        return true;
    }
}
