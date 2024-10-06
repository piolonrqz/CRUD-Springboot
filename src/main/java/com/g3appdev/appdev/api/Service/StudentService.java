package com.g3appdev.appdev.api.Service;

import java.util.List;
import java.util.NoSuchElementException;

import javax.naming.NameNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.g3appdev.appdev.api.Entity.StudentEntity;
import com.g3appdev.appdev.api.Repository.StudentRepository;

@Service
public class StudentService {
        @Autowired
    StudentRepository srepo;

    public StudentService(){
        super();
    }

    //create of CRUD

    public StudentEntity addStudentRecord(StudentEntity student){
        return srepo.save(student);
    }
    
    //read of CRUD
    public List<StudentEntity> getAllStudents(){
        return srepo.findAll();
    }

    //update of CRUD

    @SuppressWarnings("finally")
    public StudentEntity updateStudentRecord(int student_id, StudentEntity newStudent) {
        StudentEntity studentEntity = new StudentEntity();
        
        try {
            studentEntity = srepo.findById(student_id).get();
            
            studentEntity.setName(newStudent.getName());
            studentEntity.setEmail(newStudent.getEmail());
            studentEntity.setPassword(newStudent.getPassword());

        } catch (NoSuchElementException nex) {
            throw new NameNotFoundException("Student" + student_id + "not found");
        }finally{
            return srepo.save(newStudent);
        }
    }

    //delete of CRUD

    public String deleteStudent(int student_id){
        String msg = "";
        if(srepo.findById(student_id) != null){
            srepo.deleteById(student_id);
            msg = "Student record successfully deleted";
        }else{
            msg = student_id + "NOT Found!";
        }
        return msg;
    }

}