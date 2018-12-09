package src;

import java.util.Random;

public class ZombieManager {

	private int numZombies;
	private int remainingZombies;
	private Random rand;
	private double frec;

	public ZombieManager(Level level, int seed, Random rand) {
		this.numZombies = level.getNumberOfZombies();
		this.rand = rand;
		this.remainingZombies = getNumZombies();
		this.frec = level.getZombieFrequency();
		this.rand.setSeed(seed);
	}

	public int getNumZombies() {
		return numZombies;
	}

	public void setNumZombies(int numZombies) {
		this.numZombies = numZombies;
	}

	public int getRemainingZombies() {
		return this.remainingZombies;
	}
	
	public void setRemainingZombies(int remainingZombies) {
		this.remainingZombies = remainingZombies;
	}

	public boolean finPartida() {
		boolean fin = false;

		if (this.numZombies < 1) {
			fin = true;
			System.out.println("YOU WIN");
		}
		return fin;
	}

	public boolean isZombieAdded() { // Ejecutar en cada ronda del update
		boolean isAdded = false;
		double random;
		random = this.rand.nextDouble();

		if (random <= this.frec && remainingZombies > 0) {
			remainingZombies--;
			isAdded = true;
		}

		return isAdded;
	}

}
