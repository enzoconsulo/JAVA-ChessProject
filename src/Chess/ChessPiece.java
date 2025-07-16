package Chess;

import Board.Board;
import Board.Piece;

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
	
}
