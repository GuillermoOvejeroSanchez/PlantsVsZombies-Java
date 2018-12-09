package src;

public class SuncoinManager {
	private int suncoins;

	public SuncoinManager() {
		this.suncoins = 50;
	}

	public void modifySuncoins(int mod_value) {
		this.suncoins += mod_value;
	}

	public int getSuncoins() {
		return suncoins;
	}
	
	public void loadSuncoins(int value) {
		this.suncoins = value; 
	}
}
