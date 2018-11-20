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

	protected void accion() {
		if (game.isEmpty(x, y - 1))
			setY(this.y - 1);
	}

	public abstract Zombie inPosition(int x, int y,Game game);

}
