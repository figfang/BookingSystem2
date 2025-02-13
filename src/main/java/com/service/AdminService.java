package com.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.dto.BookingResponse;
import com.dto.BookingStatistics;
import com.dto.TimeSlotDTO;
import com.model.Booking;
import com.model.TimeSlot;
import com.repository.AdminRepository;
import com.repository.BookingRepository;
import com.repository.TimeSlotRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class AdminService {
    @Autowired
    private AdminRepository adminRepository;
    
    @Autowired
    private BookingRepository bookingRepository;
    
    @Autowired
    private TimeSlotRepository timeSlotRepository;
    
    

 // 查看所有訂位
    @GetMapping("/bookings")
    public ResponseEntity<List<BookingResponse>> getAllBookings(
            @RequestParam(required = false) LocalDate startDate,
            @RequestParam(required = false) LocalDate endDate) {
        return ResponseEntity.ok(adminService.getAllBookings(startDate, endDate));
    }

    // 管理時段
    @PostMapping("/time-slots")
    public ResponseEntity<TimeSlot> createTimeSlot(@RequestBody TimeSlotDTO timeSlotDTO) {
        return ResponseEntity.ok(adminService.createTimeSlot(timeSlotDTO));
    }

    @PutMapping("/time-slots/{timeSlotId}")
    public ResponseEntity<TimeSlot> updateTimeSlot(
            @PathVariable Integer timeSlotId,
            @RequestBody TimeSlotDTO timeSlotDTO) {
        return ResponseEntity.ok(adminService.updateTimeSlot(timeSlotId, timeSlotDTO));
    }

    @DeleteMapping("/time-slots/{timeSlotId}")
    public ResponseEntity<Void> deleteTimeSlot(@PathVariable Integer timeSlotId) {
        adminService.deleteTimeSlot(timeSlotId);
        return ResponseEntity.ok().build();
    }

    // 查看訂位統計
    @GetMapping("/statistics")
    public ResponseEntity<BookingStatistics> getBookingStatistics(
            @RequestParam LocalDate startDate,
            @RequestParam LocalDate endDate) {
        return ResponseEntity.ok(adminService.getBookingStatistics(startDate, endDate));
    }
}