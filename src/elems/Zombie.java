package elems;

public abstract class Zombie extends GameObject {

	public Zombie(int x, int y, int cycles, String name, String nameShort) {
		super(x, y, cycles, name, nameShort);
	}

	public boolean update() {
		return false;

	}

	public void damage(GameObject gameObject) {

	}

	public void attack() {

	}
	
	public void move() {
		
	}
}
