package application;

public class Kayitlar_Table {
	
	private int id;
	private String sutun_kulad;
	private String sifre;
	private int yetki;
	
	Kayitlar_Table(){
		this.yetki=0;
	}
	Kayitlar_Table(int id, String kuladi, String sifre, int yetki){
		this.id=id;
		this.sifre=sifre;
		this.sutun_kulad=kuladi;
		this.yetki=yetki;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSutun_kulad() {
		return sutun_kulad;
	}
	public void setSutun_kulad(String sutun_kulad) {
		this.sutun_kulad = sutun_kulad;
	}
	public String getSifre() {
		return sifre;
	}
	public void setSifre(String sifre) {
		this.sifre = sifre;
	}
	public int getYetki() {
		return yetki;
	}
	public void setYetki(int yetki) {
		this.yetki = yetki;
	}
	

}
