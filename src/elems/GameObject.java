package elems;

import src.Game;

public abstract class GameObject {
	protected int x;
	protected int y;
	protected int res;
	protected int dmg;
	protected int cycles;
	protected int cyclesLeft;
	protected String name;
	protected String nameShort;
	protected String infoName;
	protected Game game;

	protected GameObject(int x, int y, Game game) {
		this.x = x;
		this.y = y;
		this.game = game;
	}

	protected GameObject() {

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

	public void setResistance(int newRes) {
		this.res = newRes;
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

	public abstract boolean update();

	public String getInfoName() {
		return this.infoName;
	}

	public String getShortName() {
		return this.nameShort;
	}

	public void takeDmg(GameObject gameObject) {
		this.setResistance(this.res - gameObject.dmg);
	}

	public boolean isDead() {
		return this.res <= 0;
	}

	public String toString() {
		return nameShort + " [" + res + "]";
	}


	public String toStringDebug() {
		return nameShort + " [l:" + res + ",x:" + x + ",y:" + y + ",t:" + cyclesLeft + "]";
	}
	
	/*
	public String toStringDebug( ) {
		StringBuilder elem = new StringBuilder();
	
			//this.getShortName();
			elem.append(this.getShortName());
			elem.append(" [ l: ");
			elem.append(this.getResistance());
			elem.append(",x: ");
			elem.append(this.getX());
			elem.append(",y; ");
			elem.append(this.getY());
			elem.append(",t: ");
			elem.append(this.getRemainigCycles());
			elem.append("]");

		
		return elem.toString();
	}
	*/

	protected abstract boolean accion();
}
