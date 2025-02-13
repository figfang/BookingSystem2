package com.dto;

import java.time.LocalDate;

public class BookingDTO {
	
	private Integer timeSlotId;
    private LocalDate bookingDate;
	public Integer getTimeSlotId() {
		return timeSlotId;
	}
	public void setTimeSlotId(Integer timeSlotId) {
		this.timeSlotId = timeSlotId;
	}
	public LocalDate getBookingDate() {
		return bookingDate;
	}
	public void setBookingDate(LocalDate bookingDate) {
		this.bookingDate = bookingDate;
	}
    
    

}
