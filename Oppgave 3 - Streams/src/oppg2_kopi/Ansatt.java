package oppg2_kopi;

import java.util.*;

import oppg2_kopi.Kjonn;
public class Ansatt {

	private String fornavn;
	private String etternavn;
	private Kjonn kjonn;
	private String stilling;
	private int aarslønn;
	
	public Ansatt (String fornavn, String etternavn, Kjonn kjonn, String stilling, int aarslønn) {
		this.fornavn=fornavn;
		this.etternavn=etternavn;
		this.kjonn=kjonn;
		this.stilling=stilling;
		this.aarslønn=aarslønn;
	}
	
	public String getFornavn() {
		return fornavn;
	}
	
	public String getEtternavn() {
		return etternavn;
	}
	
	public Kjonn getKjonn() {
		return kjonn;
	}
	
	public String getStilling() {
		return stilling;
	}
	
	public int getAarslønn() {
		return aarslønn;
	}
	
	public void setaarslonn(int aarslonn) {
        this.aarslønn = aarslonn;
    }
}