package monopoly;

public class IncomeTaxSquare extends Square {
	public IncomeTaxSquare() {
		super("Income Tax");
	}

	public void landOnBy(Player p) {
		int worth = p.getMoney() / 10;
		int taxToPay = Math.min(5000, worth);
		p.debit(taxToPay);
	}
}
