package src;

import java.util.Random;

import elems.Plant;
import elems.Zombie;
import factory.ZombieFactory;
import lista.GameObjectList;

public class Game {
	static public final int COLUMNAS = 8;
	static public final int FILAS = 4;
	public final int MAX_PLANTAS = 24;
	private Level level;
	private GameObjectList zombieList;
	private GameObjectList plantList;
	private SuncoinManager suncoinManager;
	private ZombieManager zombieManager;
	private int seed;
	private boolean fin;
	private boolean zombieWin;
	private int ciclos;
	private Random rand;

	public Game(Level level, int seed) {
		rand = new Random();
		rand.setSeed(seed);
		this.seed = seed;
		this.ciclos = 0;
		this.level = level;
		this.fin = false;
		this.zombieWin = false;
		zombieManager = new ZombieManager(this.level, this.seed, this.rand);
		suncoinManager = new SuncoinManager();
		zombieList = new GameObjectList(zombieManager.getNumZombies());
		plantList = new GameObjectList(MAX_PLANTAS);
	}

	public void update() {
		aumentarCiclos();
		plantList.update();
		zombieList.update();
		zombieWin = checkZombieWin();
	}

	public boolean getZombieWin() {
		return zombieWin;
	}

	public int getCiclos() {
		return ciclos;
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
		suncoinManager.modifySuncoins(i);
	}

	public boolean getFin() {
		return fin;
	}

	public String getCharacterInCoordante(int x, int y) {
		String elem = " ";
		if (plantList.encontrar(x, y)) {
			elem = plantList.toString(x, y);
		}
		if (zombieList.encontrar(x, y)) {
			elem = zombieList.toString(x, y);
		}

		return elem;
	}

	public boolean checkZombieWin() {
		boolean theyWin = false;
		for (int i = 0; i < FILAS; i++) {
			if (zombieList.encontrar(FILAS, 0))
				theyWin = true;
		}
		return theyWin;
	}

	public void accionOrdenador() {

		if (this.zombieManager.isZombieAdded()) {
			int x = new Random().nextInt(FILAS);
			while (!isEmpty(x, COLUMNAS - 1))
				x = new Random().nextInt(FILAS); // Si hay 4 al principio peta el juego
			addZombie(ZombieFactory.getZombie(x, COLUMNAS - 1));
		}
	}

	public void aumentarCiclos() {
		ciclos++;
	}

	public void reset() {
		zombieManager = new ZombieManager(level, seed, rand);
		suncoinManager = new SuncoinManager();
		fin = false;
		ciclos = 0;
		zombieList = new GameObjectList(zombieManager.getNumZombies());
		plantList = new GameObjectList(MAX_PLANTAS);
	}

	public void addPlant(Plant plant) {
		plantList.addObject(plant);
	}

	public void addZombie(Zombie zombie) {
		zombieList.addObject(zombie);
	};

	public boolean isEmpty(int x, int y) {
		boolean empty = false;

		if (!plantList.encontrar(x, y))
			if (!zombieList.encontrar(x, y))
				empty = true;

		return empty;
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
//
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

}
