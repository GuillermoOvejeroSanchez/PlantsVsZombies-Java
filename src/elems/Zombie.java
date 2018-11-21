package elems;

import src.Game;

public abstract class Zombie extends GameObject {

	protected Zombie(int x, int y, Game game) {
		super(x, y, game);
	}

	protected Zombie() {

	}

	public boolean attack() {
		// game.zombieAttack(this);
		return false;
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

	protected void accion() {
		if (!(game.attack(this.x, this.y, this)))
			setY(this.y - 1);
	}

	public abstract Zombie inPosition(int x, int y, Game game);

}
