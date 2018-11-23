package elems;

import src.Game;

public class ZombieBasico extends Zombie {
/*
	public ZombieBasico(int x, int y, Game game) {
		super(x, y, game);
		inicializar();
	}

	public ZombieBasico() {
		inicializar();
	}
*/

	public final static int CICLOS = 2; 
	//public final static int	FRECUENCIA = 1; // TODO REVISAR
	public final static int DANYO = 1; 
	public final static int RESISTENCIA = 5; 
	
	public final static String NOMBRE = "[Z]ombie";
	public final static String SHORT_NAME = "Z";
	
	public ZombieBasico() {
		super(RESISTENCIA, DANYO, CICLOS, NOMBRE, SHORT_NAME);
		// TODO Auto-generated constructor stub
	}
	
	/*
	private void inicializar() {
		res = 5;
		cycles = 2;
		cyclesLeft = cycles;
		dmg = 1;
		nameShort = "Z";
		name = "zombie";
		infoName = "[Z]ombie";
	}
*/
	public Zombie inPosition(int x, int y, Game game) {
		Zombie zombie = new ZombieBasico();
		return zombie;
		
		//TODO set x, set y
	}

}
