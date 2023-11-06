package application;

public class Fiyatlar_Table {
    double Benzin95;
    double Benzin97;
    double Dizel;
    double Eurodizel;
    double LPG;
    
    Fiyatlar_Table(){
    	
    }
    
    Fiyatlar_Table(double Benzin95, double Benzin97, double Dizel, double Eurodizel, double LPG){
    	this.Benzin95=Benzin95;
    	this.Benzin97=Benzin97;
    	this.Dizel=Dizel;
    	this.Eurodizel=Eurodizel;
    	this.LPG=LPG;
    }

	public double getBenzin95() {
		return Benzin95;
	}

	public void setBenzin95(double benzin95) {
		Benzin95 = benzin95;
	}

	public double getBenzin97() {
		return Benzin97;
	}

	public void setBenzin97(double benzin97) {
		Benzin97 = benzin97;
	}

	public double getDizel() {
		return Dizel;
	}

	public void setDizel(double dizel) {
		Dizel = dizel;
	}

	public double getEurodizel() {
		return Eurodizel;
	}

	public void setEurodizel(double eurodizel) {
		Eurodizel = eurodizel;
	}

	public double getLPG() {
		return LPG;
	}

	public void setLPG(double lPG) {
		LPG = lPG;
	}
    
}
