package fr.sorbonne.paris.nord.university.api.service;

import fr.sorbonne.paris.nord.university.api.dto.TeamDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface TeamService{
    List<TeamDTO> getAllTeams();
    Optional<TeamDTO> getTeamById(Long teamId);
    void addTeam(TeamDTO team);
    void updateTeam(TeamDTO team);
    void deleteTeamById(Long teamId);
}
