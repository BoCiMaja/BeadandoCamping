package hu.uni.eku.tzs.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Foglalas
{
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