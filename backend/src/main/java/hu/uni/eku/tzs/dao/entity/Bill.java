package hu.uni.eku.tzs.dao.entity;

import lombok.*;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int Id;
    @Column
    private Integer billId;
    @Column
    private LocalDateTime arrive;
    @Column
    private LocalDateTime leave;
    @Column
    private String firstName;
    @Column
    private String surName;
    @Column
    private Integer numberOfDays;
    @Column
    private Integer totalAmount;
}
