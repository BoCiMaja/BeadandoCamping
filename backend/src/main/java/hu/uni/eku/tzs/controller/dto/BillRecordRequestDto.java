package hu.uni.eku.tzs.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BillRecordRequestDto {
    private LocalDate arrive;
    private LocalDate leave;
    private String firstName;
    private String surName;
    private short numberOfDays;
    private int totalAmount;
}
