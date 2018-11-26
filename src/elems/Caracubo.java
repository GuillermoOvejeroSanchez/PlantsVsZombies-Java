package elems;

import src.Game;

public class Caracubo extends Zombie {
/*
	public Caracubo(int x, int y, Game game) {
		super(x, y, game);
		inicializar();
	}

	public Caracubo() {
		inicializar();
	}

	private void inicializar() {
		res = 8;
		cycles = 4;
		cyclesLeft = cycles;
		dmg = 1;
		nameShort = "B";
		name = "caracubo";
		infoName = "[C]aracubo";
	}
*/
	public final static int CICLOS = 4; 
	//public final static int	FRECUENCIA = 1; // TODO REVISAR
	public final static int DANYO = 1; 
	public final static int RESISTENCIA = 8; 
	
	public final static String NOMBRE = "[C]aracubo";
	public final static String SHORT_NAME = "C";
	
	public Caracubo() {
		super(RESISTENCIA, DANYO, CICLOS, NOMBRE, SHORT_NAME);
		// TODO Auto-generated constructor stub
	}
	
	
	public Zombie inPosition(int x, int y, Game game) {
		Zombie zombie = new Caracubo();
		zombie.setX(x);
		zombie.setY(y);
		return zombie;
	}
}
