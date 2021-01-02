package hu.uni.eku.tzs.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Bill {
    private Integer billId;
    private LocalDateTime arrive;
    private LocalDateTime leave;
    private String firstName;
    private String surName;
    private Integer numberOfDays;
    private Integer totalAmount;
}

