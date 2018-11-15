package lista;

import elems.GameObject;

public class GameObjectList {

	// private final static int MAX_ELEMS = 32; aqui no lookooo en donde se vaya a
	// crear

	private GameObject[] ObjectList;
	private int contador;

	public GameObjectList(int tam) {

		this.contador = 0;
		this.ObjectList = new GameObject[tam];

	}

	// encontrar

	public int encontrar(int x, int y) {
		int i = 0;
		boolean encontrado = false;

		while (i < ObjectList.length && !encontrado) {

			if (this.ObjectList[i].getX() == x && this.ObjectList[i].getY() == y) {
				encontrado = true;
			} else
				i++;

		}

		return i;
	}

	// add
	public boolean addObjeto(GameObject objeto) {
		boolean insertado = false;

		if (!llena()) {

			ObjectList[this.contador] = objeto;
			this.contador++;
			insertado = true;

		}

		return insertado;

	}

	// delete
	public void delete(int x, int y) {
		int pos;

		pos = encontrar(x, y);

		for (int i = pos; i < ObjectList.length - 1; i++) {
			ObjectList[i] = ObjectList[i + 1];
		}
		this.contador--;

	}

	// get objeto

	public GameObject getObject(int i) {
		return this.ObjectList[i];
	}

	// llena

	public boolean llena() {
		return this.contador == ObjectList.length;
	}

	// tam lista
	public int getSize() {
		return contador;
	}

	// update
	
	public void update() {
		
		for(int i = 0; i < ObjectList.length; i++) {
			ObjectList[i].update();
		}
		
	}
	

}














