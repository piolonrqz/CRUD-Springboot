package com.g3appdev.appdev.api.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.g3appdev.appdev.api.Entity.AttendanceEntity;
import com.g3appdev.appdev.api.Repository.AttendanceRepository;

@Service
public class AttendanceService {
    @Autowired
    AttendanceRepository arepo;

    public AttendanceService(){
        super();
    }

    //create of CRUD

    public AttendanceEntity addAttendanceRecord(AttendanceEntity attendance){
        return arepo.save(attendance);
    }

    public List<AttendanceEntity> getAllAttendance(){
        return arepo.findAll();
    }

    //update of CRUD
    @SuppressWarnings("finally")
    public AttendanceEntity updateAttendanceRecord(int attendance_id, AttendanceEntity newAttendance) {
        AttendanceEntity attendanceEntity = new AttendanceEntity();
        
        try {
            attendanceEntity = arepo.findById(attendance_id).get();
            attendanceEntity.setStudent(newAttendance.getStudent());
            attendanceEntity.setPassword(newAttendance.getPassword());
            attendanceEntity.date(newAttendance.date());
            attendanceEntity.setStatus(newAttendance.getStatus());
            attendanceEntity.setSignInTime(newAttendance.getSignInTime());
            attendanceEntity.setSignOutTime(newAttendance.getSignOutTime());
            
         } catch(Exception e) {
                throw new Exception("Attendance record " + attendance_id + " not found");
        }finally{
            return arepo.save(newAttendance);
        }
}
    

    //delete of CRUD
    public String deleteAttendance(int attendance_id){
        String msg = "";
        if(arepo.findById(attendance_id) != null){
            arepo.deleteById(attendance_id);
            msg = "Attendance successfully deleted";
        }else{
            msg = attendance_id + "NOT Found!";
        }
        return msg;
    }
}
