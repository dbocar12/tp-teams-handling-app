package fr.sorbonne.paris.nord.university.api.service;

import fr.sorbonne.paris.nord.university.api.dto.TeamDTO;
import fr.sorbonne.paris.nord.university.api.entity.TeamEntity;
import fr.sorbonne.paris.nord.university.api.factory.TeamFactory;
import fr.sorbonne.paris.nord.university.api.repository.TeamRepository;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TeamServiceImpl implements TeamService {

    private final TeamRepository teamRepository;

    @Autowired
    public TeamServiceImpl(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }


    private final TeamFactory teamFactory = new TeamFactory();

    @Override
    @Transactional(readOnly = true)
    public List<TeamDTO> getAllTeams() {
        List<TeamEntity> allTeam = teamRepository.findAll();
        return allTeam.stream().map(teamFactory::toDTO).collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<TeamDTO> getTeamById(Long teamId) {
        if(teamRepository.findById(teamId).isPresent()){
            Optional<TeamEntity> byId = teamRepository.findById(teamId);
            return byId.map(teamFactory::toDTO);
        }
        else{
            return Optional.empty();
        }
    }

    @Override
    public void addTeam(TeamDTO team) {
        teamRepository.save(teamFactory.toEntity(team));
    }

    @Override
    public void updateTeam(TeamDTO team) {

        if(teamRepository.findById(team.getId()).isPresent()) {
            TeamEntity teamEntity = teamRepository.findById(team.getId()).get();
            teamEntity.setName(team.getName());
            teamEntity.setSlogan(team.getSlogan());
        }
    }

    @Override
    public void deleteTeamById(Long teamId) {
        teamRepository.deleteById(teamId);
    }
}
