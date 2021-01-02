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
public class Foglalas {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer Id;
    @Column
    private Integer foglalasId;
    @Column
    private Integer cellaSzam;
    @Column
    private LocalDateTime erkezes;
    @Column
    private LocalDateTime tavozas;
    @Column
    private String vezeteknev;
    @Column
    private String keresztnev;
    @Column
    private String telefonszam;
    @Column
    private Integer tipus;
    @Column
    private boolean aram;

}