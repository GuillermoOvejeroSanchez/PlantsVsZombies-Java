package elems;
import src.Game;
public class Zombie {
	
	//private final int VEL = 1;
	final int DMG = 1;
	final int FREC = 2;
	final int RES = 5;
	private int res;
	private int frec;
	private int x,y;
	private Game game;
	
	public Zombie(int x, int y, Game game) {
	this.res = RES;
	this.x = x;
	this.y = y;
	this.game = game;
	this.frec = FREC;
	}

	public int getRes() {
		return this.res;
	}
	
	public void takeDmg(int dmg) {
		this.res -= dmg;
		if(this.res < 1) {
			game.quitarElem(this.x, this.y);
		}
	}

	public int getX() {
		return this.x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return this.y;
	}
	
	public boolean attack() {
		boolean ataca = game.atacaZombie(this.x, this.y, this.DMG);
		return ataca;
	}
	
	public boolean moveZombie(int x, int y) {
		boolean move = false;
		move = game.moveZombie(x, y);
		if(move)
			move();
		return move;
	}
	private void move() {
		this.y = this.y - 1;
	}
	
	public boolean update() {
		boolean updated = false;
		if(this.frec == 1) {
			updated = true;
			this.frec = FREC;
		}
		else this.frec--;
		
		return updated;
	}
}
