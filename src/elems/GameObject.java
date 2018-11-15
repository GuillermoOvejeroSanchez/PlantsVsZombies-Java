package elems;

public abstract class GameObject {
	int x;
	int y;
	int res;
	int dmg;
	int cycles;
	int cyclesLeft;
	String name;

	public GameObject(int x, int y, int cycles, String name) {
		this.x = x;
		this.y = y;
		this.cyclesLeft = cycles;
	}

	public abstract String getName();

	public abstract int getDamage();

	public abstract int getCycles();

	public abstract int getResistance();

	public abstract int getCost();
}
