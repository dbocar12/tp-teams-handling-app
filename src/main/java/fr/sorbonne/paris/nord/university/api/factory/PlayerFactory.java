package fr.sorbonne.paris.nord.university.api.factory;

import fr.sorbonne.paris.nord.university.api.dto.PlayerDTO;
import fr.sorbonne.paris.nord.university.api.entity.PlayerEntity;
import org.springframework.stereotype.Component;

@Component
public class PlayerFactory implements EntityFactory<PlayerEntity, PlayerDTO>{
    @Override
    public PlayerDTO toDTO(PlayerEntity entity) {
        final PlayerDTO playerDTO = new PlayerDTO();
        playerDTO.setId(entity.getId());
        playerDTO.setName(entity.getName());
        playerDTO.setNumber(entity.getNumber());
        playerDTO.setPosition(entity.getPosition());
        return playerDTO;
    }

    @Override
    public PlayerEntity toEntity(PlayerDTO dto) {
        final PlayerEntity playerEntity = new PlayerEntity();
        playerEntity.setId(dto.getId());
        playerEntity.setName(dto.getName());
        playerEntity.setNumber(dto.getNumber());
        playerEntity.setPosition(dto.getPosition());
        return playerEntity;
    }
}
