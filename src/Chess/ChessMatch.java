package Chess;

import Board.Board;
import Board.Position;
import Chess.Pieces.King;
import Chess.Pieces.Rook;

public class ChessMatch {

	private Integer turn;
	private Color currentPlayer;
	private Boolean check;
	private Boolean checkMate;
	private ChessPiece enPassantVulnerable;
	private ChessPiece promoted;
	
	private Board board;

	public ChessMatch() {
		board = new Board(8, 8);
		InitialSetup();
	}

	public Board getBoard() {
		return board;
	}

	public ChessPiece[][] getPieces(){
		return (ChessPiece[][]) board.getPieces();
	}
	
	public void InitialSetup() {
		board.placePiece(new King(board,Color.BLACK), new Position(0,4));
		board.placePiece(new King(board,Color.WHITE), new Position(7,4));
		
		board.placePiece(new Rook(board,Color.BLACK), new Position(0,0));
		board.placePiece(new Rook(board,Color.BLACK), new Position(0,7));
		board.placePiece(new Rook(board,Color.WHITE), new Position(7,0));
		board.placePiece(new Rook(board,Color.WHITE), new Position(7,7));
	}
}
