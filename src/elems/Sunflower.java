package elems;

import src.Game;

public class Sunflower extends Plant {

	final static int COST = 20;
	final int SUNCOINS = 10;

	public Sunflower(int x, int y, Game game) {
		super(x, y, game);
		inicializar();

	}

	public Sunflower() {
		inicializar();
	}

	private void inicializar() {
		cost = 20;
		res = 2;
		cycles = 2;
		cyclesLeft = cycles;
		nameShort = "S";
		name = "sunflower";
		infoName = "[S]unflower";
	}

	@Override
	public Plant parse(String plantName, int x, int y, Game game) {
		Plant p = null;

		if (plantName.equalsIgnoreCase(name) || plantName.equalsIgnoreCase(nameShort)) {
			p = new Sunflower(x, y, game);
		}
		return p;
	}

	// Gana Soles
	public boolean accion() {
		game.modifySuncoins(SUNCOINS);
		return false;
	}

	public boolean attack() {
		return false;
	}
}
