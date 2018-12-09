
package lista;

import elems.GameObject;

public class GameObjectList {

	private GameObject[] ObjectList;
	private int contador;

	public GameObjectList(int tam) {
		this.contador = 0;
		this.ObjectList = new GameObject[tam];

	}

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

	public boolean addObject(GameObject objeto) {
		boolean insertado = false;

		if (!llena()) {
			ObjectList[this.contador] = objeto;
			this.contador++;
			insertado = true;
		}

		return insertado;

	}
	
	public void loadObject(GameObject objeto) {
		if (!llena()) {
			ObjectList[this.contador] = objeto;
			this.contador++;
			
		}
	}

	/*
	 * //ARRAY DINAMICO public boolean addObjectRedi(GameObject objeto) { boolean
	 * insertado = true;
	 * 
	 * if(contador + 1 == ObjectList.length) { GameObject[]aux
	 * =Arrays.copyOf(ObjectList, ObjectList.length*2); this.ObjectList = aux; }
	 * 
	 * ObjectList[contador] = objeto; contador++;
	 * 
	 * 
	 * return insertado; }
	 */

	public void delete(int i) {
		for (; i < contador - 1; i++) {
			ObjectList[i] = ObjectList[i + 1];
		}
		this.contador--;
	}

	private GameObject getObject(int i) {
		return this.ObjectList[i];
	}

	public String getString(int x, int y) {
		if (encontrar(x, y))
			return getObject(buscarPos(x, y)).toString();
		else
			return "";
	}

	public String getStringDebug(int pos) {
		return ObjectList[pos].toStringDebug();
	}

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

	public int clean() {
		int eliminados = 0;
		int cont_aux = contador;
		for (int i = 0; i < cont_aux;) {
			if (ObjectList[i].isDead()) {
				delete(i);
				cont_aux--;
				eliminados++;
			} else
				i++;
		}
		return eliminados;

	}
	
	public String datosLista() {
		StringBuilder datosLista = new StringBuilder();
		
			
		for(int i = 0; i < this.contador; i++) {
			
			datosLista.append(ObjectList[i].datosObjeto()); 
			datosLista.append(", ");
			
		}
		
		
		return datosLista.toString(); 
	}

}
