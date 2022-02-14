package fr.sorbonne.paris.nord.university.api.dto;


import fr.sorbonne.paris.nord.university.api.entity.PlayerEntity;
import lombok.Data;

import java.util.List;

@Data
public class TeamDTO {
    private long id;
    private String name;
    private String slogan;
    private List<PlayerDTO> players;
}
