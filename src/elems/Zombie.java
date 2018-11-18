package elems;

public abstract class Zombie extends GameObject {

	public Zombie(int x, int y, int res, int dmg, int cycles, String name, String nameShort) {
		super(x, y, res, dmg, cycles, name, nameShort);
	}

	public void attack() {

	}

	public void accion() {
		setY(this.y - 1);
	}

	public abstract Zombie inPosition(int x, int y);

}
