package application;

import Board.Position;
import Chess.ChessMatch;
import ChessConsole.UI;

public class Program {

	public static void main(String[] args) {
		ChessMatch chessmatch = new ChessMatch();
		UI.printTable(chessmatch);
		System.out.println(chessmatch.getBoard().positionExists(new Position(7, 1)));
		chessmatch.getBoard().piece(new Position(1,10));
	}

}
