package monopoly;

import java.util.*;

public class Board {
	private List _squares;

	public Board() {
		buildSquares();
		linkSquares();
	}

	public Square getStartSquare() {
		return (Square) _squares.get(0);
	}

	private void buildSquares() {
		_squares = new LinkedList();
		for (int i = 0; i < 40; i++) {
			build(i);
		}
	}

	private void build(int i) {
		switch (i) {
		case 0:
			_squares.add(new GoSquare());
			break;
		case 39:
			_squares.add(new LuxuryTaxSquare());
			break;
		case 5:
			_squares.add(new IncomeTaxSquare());
			break;
		default:
			_squares.add(new Square("Square " + i));
		}
	}

	private void linkSquares() {
		Square previous = (Square) _squares.get(_squares.size() - 1);
		Iterator it = _squares.iterator();
		while (it.hasNext()) {
			Square current = (Square) it.next();
			current.setNextSquare(current);
			previous = current;
		}
	}
}
