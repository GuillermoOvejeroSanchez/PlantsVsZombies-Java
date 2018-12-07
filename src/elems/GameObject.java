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
	protected String shortName; 

	protected Game game;

	protected GameObject(int resistencia, int danyo, int ciclos, String name, String shortName) {
		this.res = resistencia; 
		 
		this.dmg = danyo; 
		this.cycles = ciclos; 
		this.cyclesLeft = cycles; 
		this.name = name; 
		this.shortName = shortName; 
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
	
	public void setGame(Game game)
	{
		this.game = game;
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
		return this.name;
	}

	public String getShortName() {
		return this.shortName;
	}

	public void takeDmg(GameObject gameObject) {
		this.setResistance(this.res - gameObject.dmg);
	}

	public boolean isDead() {
		return this.res <= 0;
	}

	public String toString() {
		return shortName + " [" + res + "]";
	}


	public String toStringDebug() {
		return shortName + " [l:" + res + ",x:" + x + ",y:" + y + ",t:" + cyclesLeft + "]";
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
	
	public String datosObjeto() {
		StringBuilder datosObjeto = new StringBuilder(); 
		
		datosObjeto.append(getShortName()); 
		datosObjeto.append(":");
		datosObjeto.append(getResistance());
		datosObjeto.append(":");
		datosObjeto.append(getX());
		datosObjeto.append(":");
		datosObjeto.append(getY()); 
		datosObjeto.append(":");
		datosObjeto.append(getRemainigCycles());
		
		return datosObjeto.toString(); 
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	protected abstract boolean accion();
	

}
