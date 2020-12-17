package hu.uni.eku.tzs.controller.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@Data
@Builder
public class BillDto {
    private int billId;
    private LocalDate arrive;
    private LocalDate leave;
    private String firstName;
    private String surName;
    private short numberOfDays;
    private int totalAmount;
}
