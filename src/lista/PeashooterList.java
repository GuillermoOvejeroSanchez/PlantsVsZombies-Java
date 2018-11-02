package lista;

import elems.*;
//import lista.*;
//private final static int MAX_PEASHOOTER = 32; 

public class PeashooterList {
	
	private Peashooter[] peashooterList;
	private int contador = 0;
	
	public PeashooterList(int max)
	{
		this.peashooterList = new Peashooter[max]; 
		this.contador = 0; 
	}
	
	
	public int getSize() {
		return this.contador;
	}
	
	public Peashooter getPeashooter(int i) {
		return this.peashooterList[i];
	}
	
	public void atacado(int x, int y, int dmg) {
		getPeashooter(encontrar(x, y - 1)).takeDmg(dmg);
	}
	private int encontrar(int x, int y){
		int i = 0; 
		boolean encontrado = false; 
		
		while(i < contador && !encontrado) {
			if(this.peashooterList[i].getX() == x && this.peashooterList[i].getY() == y)
				encontrado = true; 
			else
				i++;
		}
		return i; 
	}
	
	public int getResElem(int x, int y) {
		int res = getPeashooter(encontrar(x, y)).getRes();
		return res;
	}
	public boolean addPeashooter(Peashooter peashooter) {
		boolean insertado = false;
		
		if(!llena()) {
			peashooterList[contador] = peashooter; 
			contador++; 
			insertado = true; 
		}
		return insertado;
	}
	
	public void eliminarPeashooter(int x, int y) {
		int pos = encontrar(x, y);
		for(int j = pos; j < contador - 1; j++)
			this.peashooterList[j] = this.peashooterList[j + 1]; 	
		
		contador--;
	}
	
	
	private boolean llena() {
		return contador == peashooterList.length; 
	}
	
	public void update() {
    	for (int i = 0; i < getSize(); i++) {	
   		 if(getPeashooter(i).update())
   			 getPeashooter(i).dispararPea(getPeashooter(i).getX(),getPeashooter(i).getY(), Peashooter.DMG);
		}
	}
	
}
