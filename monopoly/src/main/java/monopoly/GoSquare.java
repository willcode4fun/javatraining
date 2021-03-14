package monopoly;

public class GoSquare extends Square {
	public GoSquare() {
		super("Go");
	}

	public void landOnBy(Player p) {
		p.credit(40000);
	}

	public void passOverBy(Player p) {
		p.credit(20000);
	}
}
