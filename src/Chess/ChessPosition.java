package Chess;

import Board.Position;

public class ChessPosition {

	private char column;
	private Integer row;
	
	public ChessPosition(char column, Integer row) {
		super();
		if(column < 'a' || column > 'h')throw new ChessException("ERROR! ChessPosition column must be bigger than 'a' and smaller than 'h'");
		if(row < 1 || row > 8)throw new ChessException("ERROR ! ChessPosition row must be bigger than '1' and smaller than '8'");
		this.column = column;
		this.row = row;
	}

	public char getColumn() {
		return column;
	}

	public void setColumn(char column) {
		this.column = column;
	}

	public Integer getRow() {
		return row;
	}

	public void setRow(Integer row) {
		this.row = row;
	}
	
	protected Position toPosition() {
		return new Position(8-row,column -'a');
	}
	
	protected static ChessPosition fromPosition(Position position) {
		char column = (char) (position.getColumn()+'a');
		int row = 8-position.getRow();
		return new ChessPosition(column,row);
	}
	
}
