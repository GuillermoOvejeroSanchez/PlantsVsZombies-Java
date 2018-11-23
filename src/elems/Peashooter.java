package elems;

import src.Game;

public class Peashooter extends Plant {

	final static int COST = 50;

	public Peashooter(int x, int y, Game game) {
		// super(x, y, game);
		inicializar();

	}

	public Peashooter() {
		inicializar();
	}

	private void inicializar() {
		cost = 50;
		res = 3;
		cycles = 2;
		cyclesLeft = cycles;
		dmg = 1;
		nameShort = "P";
		name = "peashooter";
		infoName = "[P]eashooter";
	}

	@Override
	public Plant parse(String plantName, int x, int y, Game game) {
		Plant p = null;

		if (plantName.equalsIgnoreCase(name) || plantName.equalsIgnoreCase(nameShort)) {
			p = new Peashooter(x, y, game);
		}
		return p;
	}

	public boolean accion() {
		boolean encontrado = false;
		int posY = y + 1;
		encontrado = !game.isEmpty(x, posY);
		while (!encontrado && posY < game.getColumnas()) {
			posY++;
			encontrado = !game.isEmpty(x, posY);
		}
		if (encontrado)
			game.peashooterAttack(this.x, posY, this);
		return encontrado;
	}

	public boolean attack() {
		return false;
	}
}
