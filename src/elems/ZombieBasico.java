package elems;

import src.Game;

public class ZombieBasico extends Zombie {

	public ZombieBasico(int x, int y, Game game) {
		super(x, y, game);
		inicializar();
	}

	public ZombieBasico() {
		inicializar();
	}

	private void inicializar() {
		res = 5;
		cycles = 2;
		cyclesLeft = cycles;
		dmg = 1;
		nameShort = "Z";
		name = "zombie";
		infoName = "[Z]ombie";
	}

	public Zombie inPosition(int x, int y, Game game) {
		Zombie zombie = new ZombieBasico(x, y, game);
		return zombie;
	}

}
