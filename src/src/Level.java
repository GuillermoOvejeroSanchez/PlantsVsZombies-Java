package src;

public enum Level {

	EASY(3, 0.1, "EASY"), HARD(5, 0.2, "HARD"), INSANE(10, 0.3, "INSANE");

	private int numZombies;
	private double frecuencia;
	private String dif;

	Level(int numZombies, double frecuencia, String dif) {
		this.numZombies = numZombies;
		this.frecuencia = frecuencia;
		this.dif = dif;
	}

	public int getNumZombies() {
		return this.numZombies;
	}

	public double getFrecuencia() {
		return this.frecuencia;
	}

	public String getDif() {
		return dif;
	}
}

//pepinillo 