package Chess;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import Board.Board;
import Board.Piece;
import Board.Position;
import Chess.Pieces.Bishop;
import Chess.Pieces.King;
import Chess.Pieces.Knight;
import Chess.Pieces.Pawn;
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
		check = false;
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
	
	public Boolean getCheck() {
		return check;
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
		
		for(char i ='a';i<='h';i++) {
			board.placePiece(new Pawn(board,Color.WHITE), coord(i,2));
			board.placePiece(new Pawn(board,Color.BLACK), coord(i,7));
		}
		
		board.placePiece(new Bishop(board,Color.BLACK), coord('c',8));
		board.placePiece(new Bishop(board,Color.BLACK), coord('f',8));
		board.placePiece(new Bishop(board,Color.WHITE), coord('c',1));
		board.placePiece(new Bishop(board,Color.WHITE), coord('f',1));
		
		board.placePiece(new Knight(board,Color.BLACK), coord('b',8));
		board.placePiece(new Knight(board,Color.BLACK), coord('g',8));
		board.placePiece(new Knight(board,Color.WHITE), coord('b',1));
		board.placePiece(new Knight(board,Color.WHITE), coord('g',1));
		
		
		
		
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
		((ChessPiece)pMoving).increaseMoveCount();
		
		board.placePiece(pMoving, target.toPosition());
		
		onBoardPieces.get(onBoardPieces.indexOf(pMoving)).setPosition(target.toPosition());
		if(pEated != null) {
			capturedPieces.add(pEated);
			onBoardPieces.remove(pEated);
		}
		return pEated;
	}
	
	public void undoMove(ChessPosition source,ChessPosition target,Piece pEated) {
		Piece pMoved = board.removePiece(target.toPosition());
		((ChessPiece)pMoved).decreaseMoveCount();
		
		board.placePiece(pMoved, source.toPosition());
		onBoardPieces.get(onBoardPieces.indexOf(pMoved)).setPosition(source.toPosition());
		
		if(pEated != null) {
		board.placePiece(pEated, target.toPosition());
		capturedPieces.remove(pEated);
		onBoardPieces.add(pEated);
		}
	}
	
	public ChessPiece performChessMove(ChessPosition sourcePosition,ChessPosition targetPosition) {
		validateSourcePosition(sourcePosition);
		validateTargetPosition(sourcePosition,targetPosition);
		
		Piece capturedPiece = makeMove(sourcePosition,targetPosition);
		
		if(testCheck(currentPlayer)) {
			undoMove(sourcePosition, targetPosition, capturedPiece);
			throw new ChessException("  Your King is in check ! \n You need to solve it... Restarting the move");
		}
		
		check = testCheck(opponent(currentPlayer));
		checkMate = testCheckMate(opponent(currentPlayer));
		
		if(!checkMate)nextTurn();
		return (ChessPiece)capturedPiece;

	}
	
	public boolean[][] possibleMoves(ChessPosition source){
		validateSourcePosition(source);
		return board.piece(source.toPosition()).possibleMoves();
	}
	
	public void nextTurn() {
		turn++;
		currentPlayer = (currentPlayer == Color.WHITE) ? Color.BLACK : Color.WHITE;
	}
	
	private Color opponent(Color color) {
		return (color == Color.WHITE) ? Color.BLACK : Color.WHITE;
	}
	
	private ChessPiece king(Color color) {
		
		List<Piece> temp = onBoardPieces.stream()
								.map(x -> (ChessPiece)x)
								.filter(x->x.getColor()==color && x instanceof King)
								.collect(Collectors.toList());
		
		if(temp.size()!=1) 
			throw new IllegalStateException("There is no " + color + " king on the board");
		
		return (ChessPiece)temp.get(0);
	}
	
	private boolean testCheck(Color myColor) {
		Piece myKing = king(myColor);
		List<Piece> opponentPieceList= onBoardPieces.stream()
				.map(x->(ChessPiece)x)
				.filter(x->x.getColor() == opponent(myColor))
				.collect(Collectors.toList());
		
		for(Piece p : opponentPieceList) {
			if(p.possibleMove(myKing.getPosition()))
				return true;
		}
		return false;
	}
	
	private boolean testCheckMate(Color myColor) {
		if(!testCheck(myColor))return false;
		
		List<Piece> myPieceList= onBoardPieces.stream()
				.map(x->(ChessPiece)x)
				.filter(x->x.getColor() == myColor)
				.collect(Collectors.toList());
		
		for(Piece p : myPieceList) {
			boolean temp[][] = p.possibleMoves();
			ChessPosition sourceTest = ChessPosition.fromPosition(p.getPosition());
			
			for(int i=0;i<temp.length;i++){
				for(int j=0;j<temp[i].length;j++) {
					if(temp[i][j]) {
						Position targetTest = new Position(i,j);
						Piece capturedPiece = makeMove(sourceTest, ChessPosition.fromPosition(targetTest));
						boolean isCheck = testCheck(myColor);
						undoMove(sourceTest, ChessPosition.fromPosition(targetTest), capturedPiece);
						if(!isCheck)return false;
					}	
				}
			}
		}
		return true;
	}

}
