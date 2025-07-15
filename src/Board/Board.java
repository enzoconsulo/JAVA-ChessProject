package Board;

public class Board {

	private Integer rows;
	private Integer columns;
	
	private Piece[][] pieces;
	
	public Board(Integer rows,Integer columns) {
		this.rows = rows;
		this.columns = columns;
		pieces = new Piece[rows][columns];
	}
	

	public Integer getRows() {
		return rows;
	}


	public Integer getColumns() {
		return columns;
	}


	public Piece[][] getPieces() {
		return pieces;
	}
	

	public Piece piece(int row , int column) {
		return pieces[row][column];
	}
	
	public Piece piece(Position position) {
		return pieces[position.getRow()][position.getColumn()];
	}
	
	public void placePiece(Piece piece, Position position) {
		piece.position = position;
		pieces[position.getRow()][position.getColumn()] = piece;
	}
	
	public Piece removePiece(Position position) {
		Piece temp = pieces[position.getRow()][position.getColumn()];
		pieces[position.getRow()][position.getColumn()] = null;
		return temp;
	}
	
	public boolean positionExists(Position position) {
		if(0 <= position.getRow() 
			&& position.getRow() <= 7 
			&& 0 <= position.getColumn() 
			&& position.getColumn() <= 7)
			return true;
		
		return false;
	}
	
	
}
