package com.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dto.BookingDTO;
import com.model.Booking;
import com.model.Member;
import com.model.TimeSlot;
import com.repository.BookingRepository;
import com.repository.MemberRepository;
import com.repository.TimeSlotRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class BookingService {
    @Autowired
    private BookingRepository bookingRepository;
    
    @Autowired
    private TimeSlotRepository timeSlotRepository;
    
    @Autowired
    private MemberRepository memberRepository;
    
    @Autowired
    private SmsService smsService;
    
    public Booking createBooking(Integer memberId, BookingDTO bookingDTO) {
        Member member = memberRepository.findById(memberId)
            .orElseThrow(() -> new RuntimeException("會員不存在"));
            
        TimeSlot timeSlot = timeSlotRepository.findById(bookingDTO.getTimeSlotId())
            .orElseThrow(() -> new RuntimeException("時段不存在"));
            
        // 檢查座位是否已滿
        long bookedCount = bookingRepository.findByTimeSlot(timeSlot).size();
        if (bookedCount >= timeSlot.getMaxCapacity()) {
            throw new RuntimeException("該時段已無座位");
        }
        
        Booking booking = new Booking();
        booking.setMember(member);
        booking.setTimeSlot(timeSlot);
        booking.setBookingDate(bookingDTO.getBookingDate());
        booking.setStatus(0); // Pending
        booking.setCreateTime(LocalDateTime.now());
        
        Booking savedBooking = bookingRepository.save(booking);
        
     
        
        
        return savedBooking;
    }
    
    public Booking updateBooking(Integer bookingId, BookingDTO bookingDTO) {
        Booking booking = bookingRepository.findById(bookingId)
            .orElseThrow(() -> new RuntimeException("訂位不存在"));
            
        TimeSlot newTimeSlot = timeSlotRepository.findById(bookingDTO.getTimeSlotId())
            .orElseThrow(() -> new RuntimeException("時段不存在"));
            
        booking.setTimeSlot(newTimeSlot);
        booking.setBookingDate(bookingDTO.getBookingDate());
        
        Booking updatedBooking = bookingRepository.save(booking);
        
        
        
        return updatedBooking;
    }
    
    public void cancelBooking(Integer bookingId) {
        Booking booking = bookingRepository.findById(bookingId)
            .orElseThrow(() -> new RuntimeException("訂位不存在"));
            
        booking.setStatus(2); // Canceled
        bookingRepository.save(booking);
        
        
    }
    
    public List<Booking> getMemberBookings(Integer memberId) {
        Member member = memberRepository.findById(memberId)
            .orElseThrow(() -> new RuntimeException("會員不存在"));
            
        return bookingRepository.findByMember(member);
    }
}

