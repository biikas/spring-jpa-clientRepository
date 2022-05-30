package com.bikash.springjpa.controller;


import com.bikash.springjpa.crud.student.StudentRequest;
import com.bikash.springjpa.crud.student.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping(value = "student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping(value = "create")
    public boolean create(@RequestBody StudentRequest studentRequest){
        return studentService.createStudent(studentRequest);
    }

    @PostMapping(value="modify/{id}")
    public boolean modify(@RequestBody StudentRequest studentRequest,@PathVariable Integer id){
        return studentService.modifyStudent(studentRequest,id);
    }
}
