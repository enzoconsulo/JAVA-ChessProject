package Chess;

import java.util.ArrayList;
import java.util.List;

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
	
	private List<Piece> onBoardPieces = new ArrayList<>();
	private List<Piece> capturedPieces = new ArrayList<>();

	public ChessMatch() {
		board = new Board(8, 8);
		turn = 1;
		currentPlayer = Color.WHITE;
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
	
	public Integer getTurn() {
		return turn;
	}

	public Color getCurrentPlayer() {
		return currentPlayer;
	}

	public List<Piece> getOnBoardPieces() {
		return onBoardPieces;
	}

	public List<Piece> getCapturedPieces() {
		return capturedPieces;
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
		
		Piece[][] p = board.getPieces();
		for(int i=0;i<8;i++)
			for(int j=0;j<8;j++)
			{
				if(p[i][j] != null)onBoardPieces.add(p[i][j]);
			}
	}
	
	private void validateSourcePosition(ChessPosition cp) {
		if(!board.thereIsAPiece(cp.toPosition()))throw new ChessException("Has no piece to move in '"+cp+"' Only moves from 'a1' to 'h8' are valid");
		if(!board.piece(cp.toPosition()).isThereAnyPossibleMove())throw new ChessException("Has no possible move in '"+cp+"' ");
		if(currentPlayer != ((ChessPiece) board.piece(cp.toPosition())).getColor())throw new ChessException("Thats not the '"+((ChessPiece) board.piece(cp.toPosition())).getColor()+"' turn");
	}
	
	private void validateTargetPosition(ChessPosition source, ChessPosition target) {
		Piece actualPiece = getBoard().piece(source.toPosition());
		if(!actualPiece.possibleMove(target.toPosition()))throw new ChessException("Thats not a possible move to '"+ source + "' do");	
	}
	
	private Piece makeMove(ChessPosition source,ChessPosition target) {
		Piece pEated = board.removePiece(target.toPosition());
		Piece pMoving = board.removePiece(source.toPosition());
		board.placePiece(pMoving, target.toPosition());
		
		onBoardPieces.get(onBoardPieces.indexOf(pMoving)).setPosition(target.toPosition());
		if(pEated != null) {
			capturedPieces.add(pEated);
			onBoardPieces.remove(pEated);
		}
		
		return pEated;
	}
	
	public ChessPiece performChessMove(ChessPosition sourcePosition,ChessPosition targetPosition) {
		validateSourcePosition(sourcePosition);
		validateTargetPosition(sourcePosition,targetPosition);
		nextTurn();
		return (ChessPiece) makeMove(sourcePosition,targetPosition);

	}
	
	public boolean[][] possibleMoves(ChessPosition source){
		validateSourcePosition(source);
		return board.piece(source.toPosition()).possibleMoves();
	}
	
	public void nextTurn() {
		turn++;
		currentPlayer = (currentPlayer == Color.WHITE) ? Color.BLACK : Color.WHITE;
	}
	
	
}
