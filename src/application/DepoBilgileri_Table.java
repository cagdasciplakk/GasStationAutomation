package application;

public class DepoBilgileri_Table {
      public Double Benzin95;
      public Double Benzin97;
      public Double Dizel;
      public Double Eurodizel;
      public Double LPG;
      
      DepoBilgileri_Table() {
		// TODO Auto-generated constructor stub
	}
      
      DepoBilgileri_Table(Double Benzin95, Double Benzin97, Double Dizel, Double Eurodizel, Double LPG){
    	  this.Benzin95=Benzin95;
    	  this.Benzin97=Benzin97;
    	  this.Dizel=Dizel;
    	  this.Eurodizel=Eurodizel;
    	  this.LPG=LPG;
    	  
      }

	public Double getBenzin95() {
		return Benzin95;
	}

	public void setBenzin95(Double benzin95) {
		Benzin95 = benzin95;
	}

	public Double getBenzin97() {
		return Benzin97;
	}

	public void setBenzin97(Double benzin97) {
		Benzin97 = benzin97;
	}

	public Double getDizel() {
		return Dizel;
	}

	public void setDizel(Double dizel) {
		Dizel = dizel;
	}

	public Double getEurodizel() {
		return Eurodizel;
	}

	public void setEurodizel(Double eurodizel) {
		Eurodizel = eurodizel;
	}

	public Double getLPG() {
		return LPG;
	}

	public void setLPG(Double lPG) {
		LPG = lPG;
	}


      
      
}
