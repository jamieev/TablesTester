package tablestester;

public class AdditionQuestion extends Question {

	public AdditionQuestion(int value, int table) {
		super( table + " + " + value  + " = ", table + value);
	}
}
