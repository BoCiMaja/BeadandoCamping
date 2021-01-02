package hu.uni.eku.tzs.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BillRecordRequestDto {
    private Integer billId;
    private LocalDateTime arrive;
    private LocalDateTime leave;
    private String firstName;
    private String surName;
    private Integer numberOfDays;
    private Integer totalAmount;
}
