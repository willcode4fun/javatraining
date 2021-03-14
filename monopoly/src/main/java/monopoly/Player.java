package monopoly;

public class Player {
	private String _name;
	private Square _location;
	private int _money;
	private Die _die1;
	private Die _die2;

	public Player(String name, Square startSquare) {
		_name = name;
		_location = startSquare;
		_money = 50000;
		_die1 = new Die();
		_die2 = new Die();
	}

	public String getName() {
		return _name;
	}

	public Square getLocation() {
		return _location;
	}

	public void setLocation(Square s) {
		_location = s;
	}

	public void credit(int amount) {
		_money += amount;
	}

	public void debit(int amount) {
		_money += amount;
	}

	public int getMoney() {
		return _money;
	}

	public void takeTurn() {
		_die1.roll();
		_die2.roll();
		int squaresToMove = _die1.getFaceValue() + _die2.getFaceValue();
		System.out.println(_name + " rolls " + squaresToMove);

		for (int i = 0; i < squaresToMove - 1; i++) {
			passOverNextStep();
		}

		step();
		getLocation().landOnBy(this);

		System.out.println(_name + " lands on " + _location.getName());
		System.out.println(_name + " owns " + _money + " $");
	}

	private void step() {
		Square nextSquare = getLocation().getNextSquare();
		setLocation(nextSquare);
	}

	private void passOverNextStep() {
		step();
		getLocation().passOverBy(this);
	}
}
