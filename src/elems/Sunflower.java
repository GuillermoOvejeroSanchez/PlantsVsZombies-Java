package elems;

import src.Game;

public class Sunflower extends Plant {
	public final static int COST = 20;
	public final static int DMG = 0;
	private final int FREC = 2;
	private final int RES = 1;
	private int res;
	private int frec;
	private int x, y;
	private Game game;

	public Sunflower(int x, int y, Game game) {
		this.res = RES;
		this.x = x;
		this.y = y;
		this.game = game;
		this.frec = FREC;
	}

	public void takeDmg(int dmg) {
		this.res -= dmg;
		if (this.res <= 0) {
			game.quitarElem(this.x, this.y);
		}
	}

	public int getRes() {
		return res;
	}

	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}

	public void addSunCoin() {
		game.modifySuncoins(10);
	}

	public boolean update() {
		boolean updated = false;
		if (this.frec == 1) {
			updated = true;
			this.frec = FREC;
		} else
			this.frec--;

		return updated;
	}
}
