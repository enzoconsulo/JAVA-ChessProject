package Chess;

import Board.Board;
import Board.Piece;
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
		checkMate = false;
		InitialSetup();
	}

	public Board getBoard() {
		return board;
	}

	public ChessPiece[][] getPieces(){
		return (ChessPiece[][]) board.getPieces();
	}
	
	public Boolean getCheckMate() {
		return checkMate;
	}

	public Position coord(char column,Integer row) {
		ChessPosition cp = new ChessPosition(column, row);
		return cp.toPosition();
	}
	
	public void InitialSetup() {
		board.placePiece(new King(board,Color.BLACK), coord('e',8));
		board.placePiece(new King(board,Color.WHITE), coord('e',1));
		
		board.placePiece(new Rook(board,Color.WHITE), coord('a',1));
		board.placePiece(new Rook(board,Color.BLACK), coord('a',8));
		board.placePiece(new Rook(board,Color.WHITE), coord('h',1));
		board.placePiece(new Rook(board,Color.BLACK), coord('h',8));
	}
	
	private void validateSourcePosition(ChessPosition cp) {
		if(!board.thereIsAPiece(cp.toPosition()))throw new ChessException("Has no piece to move in '"+cp+"' Only moves from 'a1' to 'h8' are valid");
		if(!board.piece(cp.toPosition()).isThereAnyPossibleMove())throw new ChessException("Has no possible move in '"+cp+"' ");
	}
	
	private Piece makeMove(ChessPosition source,ChessPosition target) {
		Piece pEated = board.removePiece(target.toPosition());
		Piece p = board.removePiece(source.toPosition());
		board.placePiece(p, target.toPosition());
		return pEated;
	}
	
	public ChessPiece performChessMove(ChessPosition sourcePosition,ChessPosition targetPosition) {
		validateSourcePosition(sourcePosition);
		return (ChessPiece) makeMove(sourcePosition,targetPosition);

	}
	
	
}
