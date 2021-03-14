package monopoly;

public class Die {
	private int faceValue;

	public Die() {
		roll();
	}

	public void roll() {
		faceValue = (int) (Math.random() * 6) + 1;
	}

	public int getFaceValue() {
		return faceValue;
	}

	public void setFaceValue(int value) {
		faceValue = value;
	}
}
