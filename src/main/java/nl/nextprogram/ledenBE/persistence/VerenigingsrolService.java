package nl.nextprogram.ledenBE.persistence;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import nl.nextprogram.ledenBE.domain.Verenigingsrol;


@Service
@Transactional
public class VerenigingsrolService {
	
	@Autowired
	private VerenigingsrolRepository verenigingsrolRepository;
	
	public Verenigingsrol create(Verenigingsrol verenigingsrol) {
		if (verenigingsrol==null) {
			return null;
		}
		if (verenigingsrol.getId()!=0) {
			return null;
		}
		return verenigingsrolRepository.save(verenigingsrol);
	}
	
	public Optional<Verenigingsrol> findById(long id) {
		return verenigingsrolRepository.findById(id);
	}
	
	public Iterable<Verenigingsrol> findAll() {
		return verenigingsrolRepository.findAll();
	}
	
	public Verenigingsrol update(Verenigingsrol verenigingsrol) {
		if (verenigingsrol==null) {
			return null;
		}
		if (verenigingsrol.getId()<=0) {
			return null;
		}
		
		if (!verenigingsrolRepository.findById(verenigingsrol.getId()).isPresent()) {
			return null;
		};
		
		return verenigingsrolRepository.save(verenigingsrol);
	}
	
	public boolean delete(long id) {
		if (id<=0) {
			return false;
		}
		
		if (!verenigingsrolRepository.findById(id).isPresent()) {
			return false;
		};
		
		verenigingsrolRepository.deleteById(id);
		return true;
	}
	
}
