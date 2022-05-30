package com.bikash.springjpa.repository;

import com.bikash.springjpa.model.Client;
import com.bikash.springjpa.model.Student;
import com.bikash.springjpa.model.clienttokenlist.ClientToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository  extends JpaRepository<Student,Integer>{

    Student findStudentById(int id);

}
