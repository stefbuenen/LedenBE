package nl.nextprogram.ledenBE.domain;

import javax.persistence.Entity;

@Entity
public class Verenigingsrol extends Rol {
	
	private boolean cntr;
	private boolean maxLid;
	private long cntLid;
	private boolean vog;
	private boolean aut;
	public boolean isCntr() {
		return cntr;
	}
	public void setCntr(boolean cntr) {
		this.cntr = cntr;
	}
	public boolean isMaxLid() {
		return maxLid;
	}
	public void setMaxLid(boolean maxLid) {
		this.maxLid = maxLid;
	}
	public long getCntLid() {
		return cntLid;
	}
	public void setCntLid(long cntLid) {
		this.cntLid = cntLid;
	}
	public boolean isVog() {
		return vog;
	}
	public void setVog(boolean vog) {
		this.vog = vog;
	}
	public boolean isAut() {
		return aut;
	}
	public void setAut(boolean aut) {
		this.aut = aut;
	}
	
	

}
