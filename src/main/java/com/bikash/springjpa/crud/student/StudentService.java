package com.bikash.springjpa.crud.student;

public interface StudentService {


    public boolean createStudent(StudentRequest studentRequest);

    public boolean modifyStudent(StudentRequest studentRequest,int id);


//    public boolean modifyStatus();

}
