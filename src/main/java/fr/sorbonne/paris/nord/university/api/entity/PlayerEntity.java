package fr.sorbonne.paris.nord.university.api.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="Player")
public class PlayerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    private String name;
    private String number;
    private String position;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id", nullable = false)
    private TeamEntity team;

}
