package ChessConsole;

import Board.Board;
import Board.Piece;
import Chess.ChessMatch;
import Chess.ChessPiece;

public class UI {

	public static void printTable(ChessMatch cm) {
		Board board = cm.getBoard();
		Piece[][] pieces = board.getPieces();
		for (int i = 0; i < board.getRows(); i++) {
			System.out.print(8 - i +" |");
			for (int j = 0; j < board.getColumns(); j++) {
				System.out.print(" " + printPiece((ChessPiece) pieces[i][j])+ " ");
			}
		System.out.println();
		}
		System.out.println("----------------------------");
		System.out.print("  | a  b  c  d  e  f  g  h");
	}

	private static String printPiece(ChessPiece piece) {
		if (piece == null) {
			return "-";
		} else {
			return piece.toString();
		}
	}
}
