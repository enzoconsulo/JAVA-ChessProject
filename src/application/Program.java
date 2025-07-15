package application;

import Board.Board;
import Chess.ChessMatch;
import ChessConsole.UI;

public class Program {

	public static void main(String[] args) {
		ChessMatch chessmatch = new ChessMatch(new Board(8, 8));

		UI.printTable(chessmatch);
	}

}
