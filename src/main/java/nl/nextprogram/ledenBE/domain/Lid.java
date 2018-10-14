package nl.nextprogram.ledenBE.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Lid {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	long id;
	
	private String nam;
	
	@ManyToOne
	private Postcode pstcod;
	
	private String hnr;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNam() {
		return nam;
	}
	public void setNam(String nam) {
		this.nam = nam;
	}
	public Postcode getPstcod() {
		return pstcod;
	}
	public void setPstcod(Postcode pstcod) {
		this.pstcod = pstcod;
	}
	public String getHnr() {
		return hnr;
	}
	public void setHnr(String hnr) {
		this.hnr = hnr;
	}
	
	

}
