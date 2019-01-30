
package elems;

import src.Game;

public abstract class ShooterBase extends Plant {

	
	
	public ShooterBase(int coste, int frec, int resistencia, int danyo, int ciclos, String name, String shortName) {
		super(coste, frec, resistencia, danyo, ciclos, name, shortName);
		// TODO Auto-generated constructor stub
	}

	public boolean attack() {
		 {
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
	}

}
