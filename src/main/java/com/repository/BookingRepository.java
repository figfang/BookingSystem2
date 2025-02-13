package com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.model.Booking;
import com.model.Member;
import com.model.TimeSlot;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer> {
    List<Booking> findByMember(Member member);
    List<Booking> findByTimeSlot(TimeSlot timeSlot);
}
