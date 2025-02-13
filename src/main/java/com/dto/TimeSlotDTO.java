package com.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class TimeSlotDTO {
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private Integer maxCapacity;
}
