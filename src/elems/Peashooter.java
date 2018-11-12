package elems;

import src.Game;

public class Peashooter extends GameObject {

	public final static int COST = 50;
	public final static int DMG = 1;
	private final int FREC = 1;
	private int res;
	private int x, y;
	private Game game;
	private int frec;

	public Peashooter(int x, int y, Game game) {
		this.res = 3;
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
		return this.res;
	}

	public int getY() {
		return this.y;
	}

	public int getX() {
		return this.x;
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

	public void dispararPea(int x, int y, int dmg) {
		game.dispararPea(x, y, dmg);
	}

}
