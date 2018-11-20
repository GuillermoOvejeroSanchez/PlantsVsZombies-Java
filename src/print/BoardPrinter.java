package print;

import src.Game;

public abstract class BoardPrinter implements GamePrinter {

	protected final String espacio = " ";

	public BoardPrinter(Game game) {
		encodeGame(game);

	}

	abstract void encodeGame(Game game);

	public void printGame(Game game) {
		encodeGame(game);
		System.out.println(this.toString());
	}
}
