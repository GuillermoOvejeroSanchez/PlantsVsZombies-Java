package print;

import src.Game;

public class PrinterManager {

	private static BoardPrinter[] availablePrintModes = { new ReleasePrinter(Game.FILAS, Game.COLUMNAS, null),
			new DebugPrinter(null) };

//	public static String listOfAvailablePrintModes() {
//		
//		StringBuilder str = new StringBuilder();
//		for (BoardPrinter printMode : availablePrintModes) {
//			str.append(printMode.getName()+  System.lineSeparator() +  System.lineSeparator());
//		}
//		return str.toString();
//	}

	public static BoardPrinter getBoard(Game game) {

		for (BoardPrinter board : availablePrintModes) {
			// board = board.parse(game);
			if (board != null) {
				// board.setGame(game);
				return board;
			}
		}
		return null;
	}

}
