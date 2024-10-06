package com.g3appdev.appdev.api.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.g3appdev.appdev.api.Entity.AttendanceEntity;
import com.g3appdev.appdev.api.Service.AttendanceService;


@RestController
@RequestMapping("attendance")
public class AttendanceController {
    @Autowired

    AttendanceService aserv;

    @GetMapping("/printAttendance")
    public String print() {
        return "Hello, Thank you for attending this class!";
    }

    //create of CRUD
    @PostMapping("/addAttendance")
    public AttendanceEntity createAttendance(@RequestBody AttendanceEntity attendance) {
        return aserv.addAttendanceRecord(attendance);
    }

    //read of CRUD
    @GetMapping("/readAllAttendances")
    public List<AttendanceEntity> getAllAttendance(){
        return aserv.getAllAttendance();
    }

    //update of CRUD
    @PutMapping("/updateAttendance")
    public AttendanceEntity updateAttendanceRecord(@RequestParam int attendance_id, @RequestBody AttendanceEntity newAttendance) {
        return aserv.updateAttendanceRecord(attendance_id, newAttendance);
    }

    //delete of CRUD
    @DeleteMapping("/deleteAttendance/{attendance_Id}")
    public String deleteAttendance(@PathVariable int attendance_Id){
        return aserv.deleteAttendance(attendance_Id);
    }

}
