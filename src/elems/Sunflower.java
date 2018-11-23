package elems;

public class Sunflower extends Plant {


	final int SUNCOINS = 10;
	
	public final static int COSTE = 20;
	public final static int CICLOS = 2; 
	public final static int	FRECUENCIA = 1; // TODO REVISAR
	public final static int DANYO = 0; 
	public final static int RESISTENCIA = 2; 
	
	public final static String NOMBRE = "[S]unflower";
	public final static String SHORT_NAME = "S";

	
	public Sunflower() {
		super(COSTE, FRECUENCIA, RESISTENCIA, DANYO, CICLOS, NOMBRE, SHORT_NAME);
		
	}


	public Plant parse(String plantName) {
		Plant p = null;

		if (plantName.equalsIgnoreCase(NOMBRE) || plantName.equalsIgnoreCase(SHORT_NAME)) {
			p = new Sunflower();
			
			//TODO añadir x y 
		}
		return p;
	}

	// Gana Soles
	public boolean accion() {
		game.modifySuncoins(SUNCOINS);
		return false;
	}

	public boolean attack() {
		return false;
	}
	
	
	
}
