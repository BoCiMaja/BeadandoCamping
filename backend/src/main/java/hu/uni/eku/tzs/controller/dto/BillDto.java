package hu.uni.eku.tzs.controller.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@Builder
public class BillDto {
    private Integer billId;
    private LocalDateTime arrive;
    private LocalDateTime leave;
    private String firstName;
    private String surName;
    private Integer numberOfDays;
    private Integer totalAmount;
}
