package hu.uni.eku.tzs.dao.entity;

import lombok.*;
import org.hibernate.annotations.Type;

import javax.persistence.*;

import java.util.UUID;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Cella {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int Id;
    @Column
    private int cellaId;
    @Column
    private boolean allapot;
}