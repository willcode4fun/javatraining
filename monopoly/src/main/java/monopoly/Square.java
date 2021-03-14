package monopoly;

public class Square {
	private String _name;
	private Square _nextSquare;

	public Square(String name) {
		_name = name;
		_nextSquare = null;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getName() {
		return _name;
	}

	public Square getNextSquare() {
		return _nextSquare;
	}

	public void setNextSquare(Square sq) {
		_nextSquare = sq;
	}

	public void landOnBy(Player p) {
	}

	public void passOverBy(Player p) {
	}
}
