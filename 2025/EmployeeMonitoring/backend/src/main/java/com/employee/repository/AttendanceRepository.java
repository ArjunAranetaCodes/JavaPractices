package com.employee.repository;

import com.employee.model.Attendance;
import com.employee.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface AttendanceRepository extends JpaRepository<Attendance, Long> {
    List<Attendance> findByEmployee(Employee employee);
    List<Attendance> findByDate(LocalDate date);
    
    @Query("SELECT a FROM Attendance a WHERE a.date = :date")
    List<Attendance> findTodayAttendance(@Param("date") LocalDate date);
    
    Optional<Attendance> findByEmployeeAndDate(Employee employee, LocalDate date);
}

