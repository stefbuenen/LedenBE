package nl.nextprogram.ledenBE.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Postcode {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String pstcod;
	private String wpl;
	private String str;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getPstcod() {
		return pstcod;
	}
	public void setPstcod(String pstcod) {
		this.pstcod = pstcod;
	}
	public String getWpl() {
		return wpl;
	}
	public void setWpl(String wpl) {
		this.wpl = wpl;
	}
	public String getStr() {
		return str;
	}
	public void setStr(String str) {
		this.str = str;
	}
}
