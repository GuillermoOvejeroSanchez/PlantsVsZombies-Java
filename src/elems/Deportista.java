package elems;

import src.Game;

public class Deportista extends Zombie {
/*
	public Deportista(int x, int y, Game game) {
		super(x, y, game);
		inicializar();
	}

	public Deportista() {
		inicializar();
	}

	private void inicializar() {
		res = 2;
		cycles = 1;
		cyclesLeft = cycles;
		dmg = 1;
		nameShort = "D";
		name = "deportista";
		infoName = "[D]eportista";
	}
*/
	public final static int CICLOS = 1; 
	//public final static int	FRECUENCIA = 1; // TODO REVISAR
	public final static int DANYO = 1; 
	public final static int RESISTENCIA = 2; 
	
	public final static String NOMBRE = "[D]eportista";
	public final static String SHORT_NAME = "D";
	
	public Deportista() {
		super(RESISTENCIA, DANYO, CICLOS, NOMBRE, SHORT_NAME);
		// TODO Auto-generated constructor stub
	}
	
	
	public Zombie inPosition(int x, int y, Game game) {
		Zombie zombie = new Deportista();
		return zombie;
	}

}
