package application;

public class Satislar_Table {
  private String Akaryakit_Turu;
  private Double Satis_LT;
  private Double Guncel_LTfiyat;
  private Double Tutar;
  
  
  public Satislar_Table() {
	// TODO Auto-generated constructor stub
}
  
  Satislar_Table(String Akaryakit_Turu, Double Satis_LT , Double Guncel_LTfiyat, Double Tutar){
	  this.Akaryakit_Turu=Akaryakit_Turu;
	  this.Guncel_LTfiyat=Guncel_LTfiyat;
	  this.Satis_LT=Satis_LT;
	  this.Tutar=Tutar;
  }

public String getAkaryakit_Turu() {
	return Akaryakit_Turu;
}

public void setAkaryakit_Turu(String akaryakit_Turu) {
	Akaryakit_Turu = akaryakit_Turu;
}

public Double getSatis_LT() {
	return Satis_LT;
}

public void setSatis_LT(Double satis_LT) {
	Satis_LT = satis_LT;
}

public Double getGuncel_LTfiyat() {
	return Guncel_LTfiyat;
}

public void setGuncel_LTfiyat(Double guncel_LTfiyat) {
	Guncel_LTfiyat = guncel_LTfiyat;
}

public Double getTutar() {
	return Tutar;
}

public void setTutar(Double tutar) {
	Tutar = tutar;
}
  
}
