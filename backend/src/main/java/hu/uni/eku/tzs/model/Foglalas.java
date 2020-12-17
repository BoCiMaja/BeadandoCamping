package hu.uni.eku.tzs.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Foglalas
{
    private UUID Foglalas_Id;
    private int cellaSzam;
    private Date erkezes;
    private Date tavozas;
    private String vezeteknev;
    private String keresztnev;
    private String telefonszam;
    private int tipus;
    private boolean aram;
}