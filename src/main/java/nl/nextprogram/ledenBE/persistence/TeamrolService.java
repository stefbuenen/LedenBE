package nl.nextprogram.ledenBE.persistence;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import nl.nextprogram.ledenBE.domain.Teamrol;

@Service
@Transactional
public class TeamrolService {
	
	@Autowired
	private TeamrolRepository teamrolRepository;
	
	public Teamrol create(Teamrol teamrol) {
		if (teamrol==null) {
			return null;
		}
		if (teamrol.getId()!=0) {
			return null;
		}
		return teamrolRepository.save(teamrol);
	}
	
	public Optional<Teamrol> findById(long id) {
		return teamrolRepository.findById(id);
	}
	
	public Iterable<Teamrol> findAll() {
		return teamrolRepository.findAll();
	}
	
	public Teamrol update(Teamrol teamrol) {
		if (teamrol==null) {
			return null;
		}
		if (teamrol.getId()<=0) {
			return null;
		}
		
		if (!teamrolRepository.findById(teamrol.getId()).isPresent()) {
			return null;
		};
		
		return teamrolRepository.save(teamrol);
	}
	
	public boolean delete(long id) {
		if (id<=0) {
			return false;
		}
		
		if (!teamrolRepository.findById(id).isPresent()) {
			return false;
		};
		
		teamrolRepository.deleteById(id);
		return true;
	}
	
}
