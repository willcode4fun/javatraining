package monopoly;

public class LuxuryTaxSquare extends Square {
	public LuxuryTaxSquare() {
		super("Luxury Tax");
	}

	public void landOnBy(Player p) {
		p.debit(5000);
	}
}
