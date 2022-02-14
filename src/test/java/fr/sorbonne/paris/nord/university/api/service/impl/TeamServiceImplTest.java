package fr.sorbonne.paris.nord.university.api.service.impl;

import fr.sorbonne.paris.nord.university.api.dto.PlayerDTO;
import fr.sorbonne.paris.nord.university.api.dto.TeamDTO;
import fr.sorbonne.paris.nord.university.api.entity.PlayerEntity;
import fr.sorbonne.paris.nord.university.api.entity.TeamEntity;
import fr.sorbonne.paris.nord.university.api.factory.PlayerFactory;
import fr.sorbonne.paris.nord.university.api.factory.TeamFactory;
import fr.sorbonne.paris.nord.university.api.repository.PlayerRepository;
import fr.sorbonne.paris.nord.university.api.repository.TeamRepository;
import fr.sorbonne.paris.nord.university.api.service.TeamServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TeamServiceImplTest {

    @Mock
    private TeamRepository teamRepository;

    @Mock
    private PlayerRepository playerRepository;

    @Mock
    private TeamFactory teamFactory;

    @Mock
    private PlayerFactory playerFactory;

    @InjectMocks
    private TeamServiceImpl teamService;

    @Test
    void getAllTeams() {
        //GIVEN
        final ArrayList<TeamEntity> teamList = new ArrayList<>();
        teamList.add(new TeamEntity());
        List<TeamEntity> all = teamRepository.findAll();

        when(all).thenReturn(teamList);
        teamFactory.setPlayerFactory(playerFactory);
        doCallRealMethod().when(teamFactory).toDTO(any());
        //WHEN
        final List<TeamDTO> allTeams = teamService.getAllTeams();
        //THEN
        assertEquals(1, allTeams.size());
        verify(teamRepository,times(1)).findAll();
    }

    @Test
    void getTeamById() {
        // Given.
        Long id = 1L;
        // When.
        Optional<TeamDTO> result = teamService.getTeamById(id);
        // Then.
        Assertions.assertThat(result.isPresent()).isFalse();
    }

    @Test
    void addTeam() {
        //GIVEN
        teamFactory.setPlayerFactory(playerFactory);

        final TeamDTO teamDTO = new TeamDTO();

        final TeamEntity teamEntity = new TeamEntity();

        when(teamFactory.toEntity(any())).thenReturn(teamEntity);
        when(teamRepository.save(any(TeamEntity.class))).thenAnswer(i -> i.getArgument(0));
        //WHEN

        teamService.addTeam(teamDTO);


        //THEN
        verify(teamFactory).toEntity(teamDTO);
        verify(teamRepository).save(teamEntity);

    }

    @Test
    void updateTeam() {
        // GIVEN
        final TeamDTO teamDTO = new TeamDTO();
        teamDTO.setId(1L);
        teamDTO.setName("Team 1");
        teamDTO.setSlogan("Slogan1");

        final TeamEntity entity = new TeamEntity();

        when(teamRepository.findById(anyLong())).thenReturn(Optional.of(entity));

        //WHEN
        teamService.updateTeam(teamDTO);

        //THEN
        assertEquals("Team 1", entity.getName());
        assertEquals("Slogan1", entity.getSlogan());
    }

    @Test
    void deleteTeamById() {
        //GIVEN
        doNothing().when(teamRepository).deleteById(anyLong());
        //WHEN
        teamService.deleteTeamById(4L);
        //THEN
        verify(teamRepository,times(1)).deleteById(4L);

    }
}