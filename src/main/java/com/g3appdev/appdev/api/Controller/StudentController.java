package com.g3appdev.appdev.api.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.g3appdev.appdev.api.Entity.StudentEntity;
import com.g3appdev.appdev.api.Service.StudentService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("student")
public class StudentController {
    @Autowired
    
    StudentService sserv;

    @GetMapping("/print")
    public String print(){
        return "Hello, Student Piolo";
    }

    //create of CRUD
    @PostMapping("/addStudentRecord")
    public StudentEntity addStudentRecord(@RequestBody StudentEntity student){
        return sserv.addStudentRecord(student);
    }

    //read of CRUD
    @GetMapping("/readAllStudentRecord")
    public List<StudentEntity> getAllStudents(){
        return sserv.getAllStudents();
    }

    //update of CRUD
    @PutMapping("/updateStudentRecord")
    public StudentEntity updateStudentRecord(@RequestParam int student_id, @RequestBody StudentEntity newStudent) {
        return sserv.updateStudentRecord(student_id, newStudent);
    }

    //delete of CRUD
    @DeleteMapping("/deleteStudent/{student_id}")
    public String deleteStudent(@PathVariable int student_id){
        return sserv.deleteStudent(student_id);
    }
    
}
