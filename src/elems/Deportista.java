package elems;

import src.Game;

public class Deportista extends Zombie {

	public Deportista(int x, int y, Game game) {
		super(x, y, game);
		inicializar();
	}

	public Deportista() {
		inicializar();
	}

	private void inicializar() {
		res = 2;
		cycles = 1;
		cyclesLeft = cycles;
		dmg = 1;
		nameShort = "D";
		name = "deportista";
		infoName = "[D]eportista";
	}

	public Zombie inPosition(int x, int y, Game game) {
		Zombie zombie = new Deportista(x, y, game);
		return zombie;
	}

}
