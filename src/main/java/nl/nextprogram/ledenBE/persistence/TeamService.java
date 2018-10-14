package nl.nextprogram.ledenBE.persistence;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import nl.nextprogram.ledenBE.domain.Team;

@Service
@Transactional
public class TeamService {
	
	@Autowired
	private TeamRepository teamRepository;
	
	public Team create(Team team) {
		if (team==null) {
			return null;
		}
		if (team.getId()!=0) {
			return null;
		}
		return teamRepository.save(team);
	}
	
	public Optional<Team> findById(long id) {
		return teamRepository.findById(id);
	}
	
	public Iterable<Team> findAll() {
		return teamRepository.findAll();
	}
	
	public Team update(Team team) {
		if (team==null) {
			return null;
		}
		if (team.getId()<=0) {
			return null;
		}
		
		if (!teamRepository.findById(team.getId()).isPresent()) {
			return null;
		};
		
		return teamRepository.save(team);
	}
	
	public boolean delete(long id) {
		if (id<=0) {
			return false;
		}
		
		if (!teamRepository.findById(id).isPresent()) {
			return false;
		};
		
		teamRepository.deleteById(id);
		return true;
	}
	
}
