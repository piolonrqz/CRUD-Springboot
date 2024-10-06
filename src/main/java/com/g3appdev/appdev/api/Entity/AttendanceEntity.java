package com.g3appdev.appdev.api.Entity;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="tblAttendance")
public class AttendanceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = true)
    private int attendance_id;

    private String password;
    private LocalDateTime date;
    private String status;
    private LocalDateTime SignInTime;
    private LocalDateTime SignOutTime;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name ="student_id")
    @JsonIgnore
    private StudentEntity student;

    public AttendanceEntity(){
        super();
    }

    public AttendanceEntity(int attendance_id, String password, LocalDateTime date, String status, LocalDateTime SignInTime, LocalDateTime SignOutTime, StudentEntity student){
        super();
        this.attendance_id = attendance_id;
        this.password = password;
        this.date = date;
        this.status = status;
        this.SignInTime = SignInTime;
        this.SignOutTime = SignOutTime;
        this.student = student;
    }

    public void setAttendanceId(int attendance_id){
        this.attendance_id = attendance_id;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public LocalDateTime date(){
        return date;
    }
    
    public void date(LocalDateTime date){
        this.date = date;
    }

    public String getStatus(){
        return status;
    }

    public void setStatus(String status){
        this.status = status;
    }

    public LocalDateTime getSignInTime(){
        return SignInTime;
    }

    public void setSignInTime(LocalDateTime SignInTime){
        this.SignInTime = SignInTime;
    }

    public LocalDateTime getSignOutTime(){
        return SignOutTime;
    }

    public void setSignOutTime(LocalDateTime SignOutTime){
        this.SignOutTime = SignOutTime;
    }

    public StudentEntity getStudent(){
        return student;
    }

    public void setStudent(StudentEntity student){
        this.student = student;
    }
}
