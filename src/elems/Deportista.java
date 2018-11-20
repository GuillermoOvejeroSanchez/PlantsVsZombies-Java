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
		cycles = 2;
		cyclesLeft = cycles;
		dmg = 1;
		nameShort = "D";
		name = "deportista";
		infoName = "[D]eportist";
	}

	final static int FREC = 1;
	final static int DMG = 1;
	final static int RES = 2;
	final static String NAME = "deportista";
	final static String INFONAME = "[D]eportista";
	final static String SHORTNA = "D";

	public Zombie inPosition(int x, int y, Game game) {
		Zombie zombie = new Deportista(x, y, game);
		return zombie;
	}

}
