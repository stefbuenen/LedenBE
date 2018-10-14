package nl.nextprogram.ledenBE.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Functie {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String opeDat;
	private String cloDat;

	@ManyToOne
	private Lid lid;
	
	@ManyToOne
	private Verenigingsrol vereningsrol;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getOpeDat() {
		return opeDat;
	}

	public void setOpeDat(String opeDat) {
		this.opeDat = opeDat;
	}

	public String getCloDat() {
		return cloDat;
	}

	public void setCloDat(String cloDat) {
		this.cloDat = cloDat;
	}

	public Lid getLid() {
		return lid;
	}

	public void setLid(Lid lid) {
		this.lid = lid;
	}

	public Verenigingsrol getVereningsrol() {
		return vereningsrol;
	}

	public void setVereningsrol(Verenigingsrol vereningsrol) {
		this.vereningsrol = vereningsrol;
	}
	
}
