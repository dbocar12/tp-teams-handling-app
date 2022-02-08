package fr.sorbonne.paris.nord.university.api.factory;

import fr.sorbonne.paris.nord.university.api.dto.TeamDTO;
import fr.sorbonne.paris.nord.university.api.entity.TeamEntity;

public class TeamFactory implements EntityFactory<TeamEntity, TeamDTO> {

    @Override
    public TeamDTO toDTO(TeamEntity entity) {
        final TeamDTO teamDTO = new TeamDTO();
        teamDTO.setId(entity.getId());
        teamDTO.setName(entity.getName());
        teamDTO.setSlogan(entity.getSlogan());

        return teamDTO;
    }

    @Override
    public TeamEntity toEntity(TeamDTO dto) {
        final TeamEntity teamEntity = new TeamEntity();
        teamEntity.setId(dto.getId());
        teamEntity.setName(dto.getName());
        teamEntity.setSlogan(dto.getSlogan());

        return teamEntity;
    }
}
