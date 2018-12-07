package elems;

public class Petacereza extends Plant {

	public final static int COSTE = 50;
	public final static int CICLOS = 3;
	public final static int FRECUENCIA = 1; // TODO REVISAR
	public final static int DANYO = 10;
	public final static int RESISTENCIA = 2;

	public final static String NOMBRE = "Peta[c]ereza";
	public final static String SHORT_NAME = "C";

	public Petacereza() {
		super(COSTE, FRECUENCIA, RESISTENCIA, DANYO, CICLOS, NOMBRE, SHORT_NAME);
		// TODO Auto-generated constructor stub
	}

	public Plant parse(String plantName) {
		Plant p = null;

		if (plantName.equalsIgnoreCase(NOMBRE) || plantName.equalsIgnoreCase(SHORT_NAME)) {
			p = new Petacereza();

		}
		return p;
	}

//Explota
	public boolean accion() {
		for (int i = -1; i <= 1; i++) {
			for (int j = -1; j <= 1; j++) {
				if (game.isZombie(x - i, y - j)) {
					game.attackZombie(x - i, y - j, this);
				}
			}
		}
		res = 0;
		return true;
	}
}
