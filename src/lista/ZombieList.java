package lista;

import elems.ZombieBasico;

public class ZombieList {

	private int contador;
	private ZombieBasico zombieList[];

	public ZombieList(int numZombies) {

		zombieList = new ZombieBasico[numZombies];
		this.contador = 0;
	}

	public int getSize() {
		return this.contador;
	}

	public ZombieBasico getZombie(int i) {
		return this.zombieList[i];
	}

	public int getResElem(int x, int y) {
		int res = getZombie(encontrar(x, y)).getRes();
		return res;
	}

	private int encontrar(int x, int y) {
		int i = 0;
		boolean encontrado = false;

		while (i < contador && !encontrado && i < getSize()) {
			if (this.zombieList[i].getX() == x && this.zombieList[i].getY() == y)
				encontrado = true;
			else
				i++;
		}

		return i;
	}

	public void addZombie(ZombieBasico zombie) {
		zombieList[contador] = zombie;
		contador++;
	}

	public void eliminarZombie(int x, int y) {
		int pos = encontrar(x, y);
		for (int j = pos; j < contador - 1; j++)
			this.zombieList[j] = this.zombieList[j + 1];

		this.contador--;
	}

	public void atacado(int x, int y, int dmg) {
		getZombie(encontrar(x, y)).takeDmg(dmg);
	}

	public boolean update() {
		boolean fin = false;
		for (int i = 0; i < getSize(); i++) {
			boolean ataca = getZombie(i).attack();

			if (getZombie(i).update() && !ataca)
				fin = getZombie(i).moveZombie(getZombie(i).getX(), getZombie(i).getY());
		}
		return fin;
	}

}
