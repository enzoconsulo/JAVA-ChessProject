package Chess;

import Board.Board;
import Board.Piece;
import Board.Position;

public abstract class ChessPiece extends Piece{

	private Color color;
	private Integer moveCount;
	
	public ChessPiece(Board board, Color color) {
		super(board);
		this.color = color;
		moveCount = 0;
	}

	public Color getColor() {
		return color;
	}

	public Integer getMoveCount() {
		return moveCount;
	}
	
	protected boolean isThereOpponentPiece(Position position){
		ChessPiece p = (ChessPiece) getBoard().piece(position);
		return (p != null) && (p.getColor() != color);
	}
	
}
