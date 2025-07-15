package Chess;

import Board.Board;

public class ChessMatch {

	private Integer turn;
	private Color currentPlayer;
	private Boolean check;
	private Boolean checkMate;
	private ChessPiece enPassantVulnerable;
	private ChessPiece promoted;
	
	private Board board;

	public ChessMatch(Board board) {
		super();
		this.board = board;
	}

	public Board getBoard() {
		return board;
	}

	public ChessPiece[][] getPieces(){
		return (ChessPiece[][]) board.getPieces();
	}
}
