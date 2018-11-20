package elems;

import src.Game;

public class Caracubo extends Zombie {

	public Caracubo(int x, int y, Game game) {
		super(x, y, game);
		inicializar();
	}

	public Caracubo() {
		inicializar();
	}

	private void inicializar() {
		res = 8;
		cycles = 4;
		cyclesLeft = cycles;
		dmg = 1;
		nameShort = "B";
		name = "caracubo";
		infoName = "[C]aracubo";
	}

	public Zombie inPosition(int x, int y, Game game) {
		Zombie zombie = new Caracubo(x, y, game);
		return zombie;
	}
}
