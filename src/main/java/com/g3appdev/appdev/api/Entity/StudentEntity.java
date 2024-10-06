package com.g3appdev.appdev.api.Entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tblstudent")
public class StudentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(nullable = true)
    private int student_id;

    @Column(name="name")
    private String name;
    private String email;
    private String password;


    @OneToMany(fetch = FetchType.LAZY, mappedBy = "student",
                cascade = CascadeType.ALL)

    private List<AttendanceEntity> attendanceList;

    public StudentEntity(){
        super();
    }

    public StudentEntity(int student_id, String name, String email, String password){
        super();
        this.student_id = student_id;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public void setStudentId(int student_id){
        this.student_id = student_id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public List<AttendanceEntity> getAttendanceList(){
        return attendanceList;
    }

    public void setAttendanceList(List<AttendanceEntity> attendanceList){
        this.attendanceList = attendanceList;
    }
}
