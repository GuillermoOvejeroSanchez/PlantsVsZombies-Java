package elems;

public class Repeater extends ShooterBase {

	public final static int COSTE = 90;
	public final static int CICLOS = 2;
	public final static int FRECUENCIA = 1; // TODO REVISAR
	public final static int DANYO = 1;
	public final static int RESISTENCIA = 3;

	public final static String NOMBRE = "[R]epeater";
	public final static String SHORT_NAME = "R";

	public Repeater() {
		super(COSTE, FRECUENCIA, RESISTENCIA, DANYO, CICLOS, NOMBRE, SHORT_NAME);
	}

	public Plant parse(String plantName) {
		Plant p = null;

		if (plantName.equalsIgnoreCase(NOMBRE) || plantName.equalsIgnoreCase(SHORT_NAME)) {
			p = new Repeater();
		}
		return p;
	}
	public boolean accion() {
			if(attack()) //Si no encuentra ninguna la primera vez que ataca no vuelve a atacar la segunda pues tampoco va a encontrar nada
				return attack();
			else
				return false;
			
	}
	/*

	public boolean attack() {
		boolean encontrado = false;
		int posY = y + 1;

		encontrado = game.isZombie(x, posY);
		while (!encontrado && posY < Game.COLUMNAS) {
			posY++;
			encontrado = game.isZombie(x, posY);
		}
		if (encontrado)
			game.peashooterAttack(this.x, posY, this);
		return encontrado;
	}
*/
}
