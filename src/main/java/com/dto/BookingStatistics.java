package com.dto;

import lombok.Data;

@Data
public class BookingStatistics {
    private Integer totalBookings;
    private Integer confirmedBookings;
    private Integer canceledBookings;
}
