package Board;

public abstract class Piece {

	protected Position position;
	
	private Board board;

	public Piece(Board board) {
		super();
		this.board = board;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public Board getBoard() {
		return board;
	}

	public void setBoard(Board board) {
		this.board = board;
	}
	
	public abstract boolean[][] possibleMoves();
	
	public boolean possibleMove(Position position) {
		return possibleMoves()[position.getRow()][position.getColumn()];
	}
	
	public boolean isThereAnyPossibleMove() {
		boolean[][] temp = possibleMoves();
		for(int i = 0 ; i<temp.length;i++) {
			for(int j = 0;j<temp[i].length;j++) {
				if(temp[i][j]==true) {
					return true;
				}
			}
		}
		return false;
	}
}
