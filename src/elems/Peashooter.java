package elems;

import src.Game;

public class Peashooter extends Plant {

	public final static int COSTE = 50;
	public final static int CICLOS = 2;
	public final static int FRECUENCIA = 1; // TODO REVISAR
	public final static int DANYO = 1;
	public final static int RESISTENCIA = 3;

	public final static String NOMBRE = "[P]eashooter";
	public final static String SHORT_NAME = "P";

	public Peashooter() {
		super(COSTE, FRECUENCIA, RESISTENCIA, DANYO, CICLOS, NOMBRE, SHORT_NAME);
	}

	public Plant parse(String plantName) {
		Plant p = null;

		if (plantName.equalsIgnoreCase(NOMBRE) || plantName.equalsIgnoreCase(SHORT_NAME)) {
			p = new Peashooter();
		}
		return p;
	}

	public boolean accion() {
		boolean encontrado = false;
		int posY = y + 1;

		encontrado = game.isZombie(x, posY);
		while (!encontrado && posY < Game.COLUMNAS) {
			posY++;
			encontrado = game.isZombie(x, posY);
		}
		if (encontrado)
			game.peashooterAttack(this.x, posY, this);
		return encontrado;
	}

	public boolean attack() {
		return false;
	}

}
