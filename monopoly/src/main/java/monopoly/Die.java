package monopoly;

public class Die {
	private int faceValue;

	public Die() {
		roll();
	}

	public void roll() {
		faceValue = (int) (Math.random() * 6) + 1;
	}

	public int getValue() {
		return faceValue;
	}

}
