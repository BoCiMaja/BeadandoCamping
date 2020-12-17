package hu.uni.eku.tzs.dao.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.*;
import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int Id;
    @Column
    private int billId;
    @Column
    private LocalDate arrive;
    @Column
    private LocalDate leave;
    @Column
    private String firstName;
    @Column
    private String surName;
    @Column
    private short numberOfDays;
    @Column
    private int totalAmount;
}
