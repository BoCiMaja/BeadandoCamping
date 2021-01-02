package hu.uni.eku.tzs.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FoglalasRecordRequestDto {

    private Integer FoglalasId;
    private Integer cellaSzam;
    private LocalDateTime erkezes;
    private LocalDateTime tavozas;
    private String vezeteknev;
    private String keresztnev;
    private String telefonszam;
    private Integer tipus;
    private boolean aram;
}