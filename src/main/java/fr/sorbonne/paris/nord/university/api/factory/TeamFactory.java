package fr.sorbonne.paris.nord.university.api.factory;

import fr.sorbonne.paris.nord.university.api.dto.PlayerDTO;
import fr.sorbonne.paris.nord.university.api.dto.TeamDTO;
import fr.sorbonne.paris.nord.university.api.entity.PlayerEntity;
import fr.sorbonne.paris.nord.university.api.entity.TeamEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class TeamFactory implements EntityFactory<TeamEntity, TeamDTO> {

    private PlayerFactory playerFactory;

    public TeamFactory() {
        playerFactory = new PlayerFactory();
    }

    @Override
    public TeamDTO toDTO(TeamEntity entity) {
        final TeamDTO teamDTO = new TeamDTO();
        teamDTO.setId(entity.getId());
        teamDTO.setName(entity.getName());
        teamDTO.setSlogan(entity.getSlogan());

        List<PlayerEntity> playersEntity = entity.getPlayers();
        List<PlayerDTO> playersDTO = playersEntity.stream()
                    .map(playerFactory::toDTO)
                    .collect(Collectors.toList());


        teamDTO.setPlayers(playersDTO);
        return teamDTO;
    }

    @Override
    public TeamEntity toEntity(TeamDTO dto) {
        final TeamEntity teamEntity = new TeamEntity();
        teamEntity.setId(dto.getId());
        teamEntity.setName(dto.getName());
        teamEntity.setSlogan(dto.getSlogan());

        List<PlayerDTO> playersDTO = dto.getPlayers();

        List<PlayerEntity> playersEntity = playersDTO.stream()
                .map(playerFactory::toEntity)
                .collect(Collectors.toList());

        teamEntity.setPlayers(playersEntity);

        return teamEntity;
    }

    public PlayerFactory getPlayerFactory() {
        return playerFactory;
    }

    public void setPlayerFactory(PlayerFactory playerFactory) {
        this.playerFactory = playerFactory;
    }
}
