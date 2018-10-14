package nl.nextprogram.ledenBE.persistence;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import nl.nextprogram.ledenBE.domain.Teamdeelname;

@Service
@Transactional
public class TeamdeelnameService {
	
	@Autowired
	private TeamdeelnameRepository teamdeelnameRepository;
	
	public Teamdeelname create(Teamdeelname teamdeelname) {
		if (teamdeelname==null) {
			return null;
		}
		if (teamdeelname.getId()!=0) {
			return null;
		}
		return teamdeelnameRepository.save(teamdeelname);
	}
	
	public Optional<Teamdeelname> findById(long id) {
		return teamdeelnameRepository.findById(id);
	}
	
	public Iterable<Teamdeelname> findAll() {
		return teamdeelnameRepository.findAll();
	}
	
	public Teamdeelname update(Teamdeelname teamdeelname) {
		if (teamdeelname==null) {
			return null;
		}
		if (teamdeelname.getId()<=0) {
			return null;
		}
		
		if (!teamdeelnameRepository.findById(teamdeelname.getId()).isPresent()) {
			return null;
		};
		
		return teamdeelnameRepository.save(teamdeelname);
	}
	
	public boolean delete(long id) {
		if (id<=0) {
			return false;
		}
		
		if (!teamdeelnameRepository.findById(id).isPresent()) {
			return false;
		};
		
		teamdeelnameRepository.deleteById(id);
		return true;
	}
	
}
