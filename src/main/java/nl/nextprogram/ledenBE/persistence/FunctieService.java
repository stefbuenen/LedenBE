package nl.nextprogram.ledenBE.persistence;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import nl.nextprogram.ledenBE.domain.Functie;

@Service
@Transactional
public class FunctieService {
	
	@Autowired
	private FunctieRepository functieRepository;
	
	public Functie create(Functie functie) {
		if (functie==null) {
			return null;
		}
		if (functie.getId()!=0) {
			return null;
		}
		return functieRepository.save(functie);
	}
	
	public Optional<Functie> findById(long id) {
		return functieRepository.findById(id);
	}
	
	public Iterable<Functie> findAll() {
		return functieRepository.findAll();
	}
	
	public Functie update(Functie functie) {
		if (functie==null) {
			return null;
		}
		if (functie.getId()<=0) {
			return null;
		}
		
		if (!functieRepository.findById(functie.getId()).isPresent()) {
			return null;
		};
		
		return functieRepository.save(functie);
	}
	
	public boolean delete(long id) {
		if (id<=0) {
			return false;
		}
		
		if (!functieRepository.findById(id).isPresent()) {
			return false;
		};
		
		functieRepository.deleteById(id);
		return true;
	}
	
}
