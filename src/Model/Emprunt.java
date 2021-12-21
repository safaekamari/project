package Model;

import java.util.Date;

public class Emprunt {

	private static int idE=0;
	private final int Id;
	private final int IdClient;
	private final int IdKindle;
	private final Date date;
	private int Lo;
	private int La;
	
	
	public Emprunt(int idc, int idk, Date d , int lo, int la) {
		this.Id=++idE;
		this.IdClient=idc;
		this.IdKindle=idk;
		this.date=d;
	}


	public int getIdClient() {
		return IdClient;
	}


	public int getIdKindle() {
		return IdKindle;
	}


	public Date getDate() {
		return date;
	}


	public int getLo() {
		return Lo;
	}


	public void setLo(int lo) {
		Lo = lo;
	}


	public int getLa() {
		return La;
	}


	public void setLa(int la) {
		La = la;
	}
	
	
	
}
