package fr.sorbonne.paris.nord.university.api.entity;

import lombok.Data;
import org.hibernate.mapping.IdGenerator;

import javax.persistence.*;

@Data
@Entity
@Table(name="team")
public class TeamEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private String name;
    private String slogan;

}
