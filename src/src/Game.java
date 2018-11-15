package src;

import java.util.Random;

import elems.Plant;

public class Game {
	static public final int COLUMNAS = 8;
	static public final int FILAS = 4;
	public final int MAX_PLANTAS = 32;
	private Level level;
	// private Elements[][] board;
	private SuncoinManager suncoinManager;
	private ZombieManager zombieManager;
	private int seed;
	private boolean fin;
	private int ciclos;
	private Random rand;

	public Game(Level level, int seed) {
		rand = new Random();
		rand.setSeed(seed);
		this.seed = seed;
		this.ciclos = 0;
		this.level = level;
		this.fin = false;
		zombieManager = new ZombieManager(this.level, this.seed, this.rand);
		suncoinManager = new SuncoinManager();
	}

	public void update() {
		aumentarCiclos();

		if (!fin)
			this.fin = zombieManager.finPartida();
	}

	public int getCiclos() {
		return this.ciclos;
	}

	public int getSuncoins() {
		return suncoinManager.getSuncoins();
	}

	public int getNumZombies() {
		return zombieManager.getNumZombies();
	}

	public int getRemainingZombies() {
		return zombieManager.getRemainingZombies();
	}

	public void modifySuncoins(int i) {
		this.suncoinManager.modifySuncoins(i);
	}

	public boolean getFin() {
		return fin;
	}
//
//	public boolean dispararPea(int x, int y, int dmg) {
//		boolean zombieEncontrado = false;
//
//		while (y < COLUMNAS && !zombieEncontrado) {
//			zombieEncontrado = (board[x][y].equals(Elements.ZOMBIE));
//			y++;
//		}
//
//		if (zombieEncontrado)
//			zList.atacado(x, y - 1, dmg);
//
//		return zombieEncontrado;
//	}
//
//	public boolean atacaZombie(int x, int y, int dmg) {
//		boolean ataca = false;
//
//		if (y - 1 >= 0) {
//
//			if (this.board[x][y - 1].equals(Elements.SUNFLOWER)) {
//				sList.atacado(x, y, dmg);
//				ataca = true;
//			}
//
//			else if (this.board[x][y - 1].equals(Elements.PEASHOOTER)) {
//				this.pList.atacado(x, y, dmg);
//				ataca = true;
//			}
//
//		}
//		return ataca;
//	}

//	public boolean addPea(int x, int y) {
//		boolean added = false;
//		if (this.board[x][y].equals(Elements.VACIO) && this.suncoinManager.getSuncoins() >= Peashooter.COST) {
//			Peashooter peashooter = new Peashooter(x, y, this);
//			this.pList.addPeashooter(peashooter);
//			this.board[x][y] = Elements.PEASHOOTER;
//			this.suncoinManager.modifySuncoins(-Peashooter.COST);
//			added = true;
//		}
//		return added;
//	}
//
//	public boolean addSunflo(int x, int y) {
//		boolean added = false;
//		if (this.board[x][y].equals(Elements.VACIO) && this.suncoinManager.getSuncoins() >= Sunflower.COST) {
//			Sunflower sunflower = new Sunflower(x, y, this);
//			this.sList.addSunflower(sunflower);
//			this.board[x][y] = Elements.SUNFLOWER;
//			this.suncoinManager.modifySuncoins(-Sunflower.COST);
//			added = true;
//		}
//		return added;
//	}
//
//	public boolean addZombie(int x, int y) {
//		boolean added = false;
//		if (this.board[x][y].equals(Elements.VACIO)) {
//			ZombieBasico zombie = new ZombieBasico();
//			this.zList.addZombie(zombie);
//			this.board[x][y] = Elements.ZOMBIE;
//			added = true;
//		}
//		return added;
//	}
//
//	public boolean moveZombie(int x, int y) {
//		boolean moved = false;
//
//		if (y - 1 >= 0) {
//			if (board[x][y - 1].equals(Elements.VACIO)) {
//				board[x][y - 1] = Elements.ZOMBIE;
//				board[x][y] = Elements.VACIO;
//				moved = true;
//			}
//		} else {
//			this.fin = true;
//			System.out.println("YOU LOST");
//		}
//
//		return moved;
//	}
//
//	public void quitarElem(int x, int y) {
//		if (this.board[x][y].equals(Elements.PEASHOOTER)) {
//			this.pList.eliminarPeashooter(x, y);
//			this.board[x][y] = Elements.VACIO;
//		} else if (this.board[x][y].equals(Elements.SUNFLOWER)) {
//			this.sList.eliminarSunflower(x, y);
//			this.board[x][y] = Elements.VACIO;
//		} else if (this.board[x][y].equals(Elements.ZOMBIE)) {
//			this.zList.eliminarZombie(x, y);
//			this.zombieManager.setNumZombies(this.zombieManager.getNumZombies() - 1);
//			this.board[x][y] = Elements.VACIO;
//		}
//	}

	public String getCharacterInCoordante(int x, int y) {
		String elemento = " ";
//TODO encode
		return elemento;
	}

	public void accionOrdenador() {

		if (this.zombieManager.isZombieAdded()) {
		}
	}

	public void aumentarCiclos() {
		this.ciclos++;
	}

	public void reset() {
		zombieManager = new ZombieManager(level, seed, rand);
		suncoinManager = new SuncoinManager();
		this.fin = false;
		this.ciclos = 0;
		// TODO Crear listas
	}

//
//	public void iniciarTablero() {
//		board = new Elements[FILAS][COLUMNAS];
//		for (int i = 0; i < FILAS; i++)
//			for (int j = 0; j < COLUMNAS; j++)
//				board[i][j] = Elements.VACIO;
//	}
//TODO
	public void addPlantToGame(Plant plant, int x, int y) {

	}

}
