package hu.uni.eku.tzs.controller.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Data
@Builder
public class FoglalasDto {
    private Integer Foglalas_Id;
    private Integer cellaSzam;
    private Date erkezes;
    private Date tavozas;
    private String vezeteknev;
    private String keresztnev;
    private String telefonszam;
    private Integer tipus;
    private boolean aram;
}
