package com.dto;

import java.time.LocalDate;

import com.model.TimeSlot;

import lombok.Data;

@Data
public class BookingResponse {
    private Integer bookingId;
    private String memberName;
    private String memberPhone;
    private LocalDate bookingDate;
    private TimeSlot timeSlot;
    private Integer status;
}
