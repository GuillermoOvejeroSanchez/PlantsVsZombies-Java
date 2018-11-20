package print;
import src.*;


public class ReleasePrinter extends BoardPrinter {

	public ReleasePrinter(int fila, int columna, Game game) {
		super(fila, columna);
		
	}

	
	public void encodeGame(Game game) {
	board = new String[filas][columnas]; 
	
	for(int i = 0 ; i < filas; i++) {
		for(int j  = 0; j < columnas; j++) {
			board[i][j] = espacio; // TODO pintar bichos 
		}
	}
		
	}
	
	

}
