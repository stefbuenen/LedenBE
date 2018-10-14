package nl.nextprogram.ledenBE.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Teamdeelname {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;

	@ManyToOne
	private Functie functie;

	@ManyToOne
	private Team team;

	@ManyToOne
	private Teamrol rol;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Functie getFunctie() {
		return functie;
	}

	public void setFunctie(Functie functie) {
		this.functie = functie;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	public Teamrol getRol() {
		return rol;
	}

	public void setRol(Teamrol rol) {
		this.rol = rol;
	}

	
}
