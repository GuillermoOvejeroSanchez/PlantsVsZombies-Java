
package lista;

import elems.GameObject;

public class GameObjectList {
	// prueba

	private GameObject[] ObjectList;
	private int contador;

	public GameObjectList(int tam) {
		this.contador = 0;
		this.ObjectList = new GameObject[tam];

	}

	// encontrar

	public boolean encontrar(int x, int y) {
		int i = 0;
		boolean encontrado = false;

		while (i < this.contador && !encontrado) {

			if (this.ObjectList[i].getX() == x && this.ObjectList[i].getY() == y) {
				encontrado = true;
			} else
				i++;

		}

		return encontrado;
	}

	private int buscarPos(int x, int y) {
		int pos = 0;
		boolean encontrado = false;

		while (pos < contador && !encontrado) {

			if (this.ObjectList[pos].getX() == x && this.ObjectList[pos].getY() == y) {
				encontrado = true;
			} else
				pos++;

		}

		return pos;
	}

	// add
	public boolean addObject(GameObject objeto) {
		boolean insertado = false;

		if (!llena()) {
			ObjectList[this.contador] = objeto;
			this.contador++;
			insertado = true;
		}

		return insertado;

	}

	// delete
	public void delete(int i) {
		for (; i < contador - 1; i++) {
			ObjectList[i] = ObjectList[i + 1];
		}
		this.contador--;
	}

	private GameObject getObject(int i) {
		return this.ObjectList[i];
	}

	public String toString(int x, int y) {
		StringBuilder elem = new StringBuilder();
		if (encontrar(x, y)) {
			GameObject go = this.getObject(buscarPos(x, y));
			elem.append(go.getShortName().toUpperCase());
			elem.append("[");
			elem.append(go.getResistance());
			elem.append("]");

		}
		return elem.toString();
	}

	// tam lista
	public int getSize() {
		return contador;
	}

	public void update() {
		for (int i = 0; i < contador; i++) {
			ObjectList[i].update();
		}
	}

	public boolean llena() {
		return this.contador == ObjectList.length;
	}

	public void getAttacked(int x, int y, GameObject go) {
		if (encontrar(x, y)) {
			getObject(buscarPos(x, y)).takeDmg(go);
		}
	}

	public void clean() {
		for (int i = 0; i < contador; i++) {
			if (ObjectList[i].isDead()) {
				delete(i);
			}
		}

	}

}
