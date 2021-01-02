package hu.uni.eku.tzs.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.time.LocalDate;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Bill {
    private Integer billId;
    private LocalDate arrive;
    private LocalDate leave;
    private String firstName;
    private String surName;
    private short numberOfDays;
    private Integer totalAmount;
}

