package com.g3appdev.appdev.api.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.g3appdev.appdev.api.Entity.*;

@Repository
public interface AttendanceRepository extends JpaRepository<AttendanceEntity, Integer> 
{
    
}
