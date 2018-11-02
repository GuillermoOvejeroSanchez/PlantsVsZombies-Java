package src;

public enum Level {
	
	EASY(3, 0.1),
	HARD(5, 0.2),
	INSANE(10, 0.3);
	
	private int numZombies;
	private double frecuencia;
	
	Level(int numZombies, double frecuencia) {
		this.numZombies = numZombies;
		this.frecuencia = frecuencia;
	}
	
	public int getNumZombies() {
		return this.numZombies;
	}
	
	public double getFrecuencia() {
		return this.frecuencia;
	}
}

//pepinillo 