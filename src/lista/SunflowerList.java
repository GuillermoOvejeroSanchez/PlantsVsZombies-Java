package lista;

import elems.Sunflower;

public class SunflowerList {

	private Sunflower[] sunflowerList;
	private int contador;

	public SunflowerList(int num) {
		sunflowerList = new Sunflower[num];
		this.contador = 0;
	}

	public void update() {
		for (int i = 0; i < getSize(); i++) {
			if (getSunflower(i).update())
				getSunflower(i).addSunCoin();
		}
	}

	public Sunflower getSunflower(int i) {
		return this.sunflowerList[i];
	}

	public int getSize() {
		return this.contador;
	}

	public int getResElem(int x, int y) {
		int res = getSunflower(encontrar(x, y)).getRes();
		return res;
	}

	public void atacado(int x, int y, int dmg) {
		getSunflower(encontrar(x, y - 1)).takeDmg(dmg);
	}

	private int encontrar(int x, int y) {
		int i = 0;
		boolean encontrado = false;

		while (i < contador && !encontrado) {
			if (this.sunflowerList[i].getX() == x && this.sunflowerList[i].getY() == y)
				encontrado = true;
			else
				i++;
		}

		return i;
	}

	public boolean addSunflower(Sunflower sunflower) {
		boolean insertado;
		insertado = false;
		if (!llena()) {
			sunflowerList[contador] = sunflower;
			contador++;
			insertado = true;
		}
		return insertado;
	}

	public void eliminarSunflower(int x, int y) {
		int pos = encontrar(x, y);
		for (int j = pos; j < contador - 1; j++)
			this.sunflowerList[j] = this.sunflowerList[j + 1];

		contador--;
	}

	private boolean llena() {

		return this.contador == sunflowerList.length;
	}

}// corchete clase
