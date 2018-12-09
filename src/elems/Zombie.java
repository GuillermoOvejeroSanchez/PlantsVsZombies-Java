package elems;

import src.Game;

public abstract class Zombie extends GameObject {
/*
	protected Zombie(int x, int y, Game game) {
		super(x, y, game);
	}

	protected Zombie() {

	}
*/
	public Zombie(int resistencia, int danyo, int ciclos, String name, String shortName) {
		super(resistencia,  danyo,  ciclos,  name,  shortName);
	
	}
	
	public boolean update() {
		int ciclos = -1;
		if (!(game.attack(this.x, this.y, this)))
			if (game.isEmpty(x, y - 1)) {
				ciclos = --this.cyclesLeft;
				if (this.cyclesLeft == 0) {
					this.accion();
					this.cyclesLeft = this.cycles;
				}
			}
		return ciclos == 0;
	}

	protected boolean accion() {
		if (!(game.attack(this.x, this.y, this)))
			setY(this.y - 1);
		return false;
	}

	public abstract Zombie inPosition(int x, int y, Game game);
	public abstract Zombie parse(String name);

}
