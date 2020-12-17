package hu.uni.eku.tzs.dao.entity;

import lombok.*;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Foglalas {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int Id;
    @Column
    private int Foglalas_Id;
    @Column
    private int cellaSzam;
    @Column
    private Date erkezes;
    @Column
    private Date tavozas;
    @Column
    private String vezeteknev;
    @Column
    private String keresztnev;
    @Column
    private String telefonszam;
    @Column
    private int tipus;
    @Column
    private boolean aram;

}