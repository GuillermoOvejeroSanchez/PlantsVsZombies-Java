package elems;

public abstract class GameObject {
	int x;
	int y;
	int res;
	int dmg;
	int cycles;
	int cyclesLeft;
	String name;
	String nameShort;

	public GameObject(int x, int y, int res,int dmg,int cycles, String name, String nameShort) {
		this.x = x;
		this.y = y;
		this.cycles = cycles;
		this.cyclesLeft = cycles;
		this.name = name;
		this.res = res;
		this.dmg = dmg;
		this.nameShort = nameShort;
	}

	public GameObject() {

	}

	public int getDamage() {

		return this.dmg;
	}

	public int getCycles() {
		return this.cycles;
	}

	public int getRemainigCycles() {
		return this.cyclesLeft;
	}

	public void setRemainigCycles(int cycles) {
		this.cyclesLeft = cycles;
	}

	public int getResistance() {
		return this.res;
	}

	public void setResistance(int resistance) {
		this.res = resistance;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public boolean update() {

		return true;
	}

	public String getName() {
		return this.name;
	}

	public String getShortName() {
		return this.nameShort;
	}
}
