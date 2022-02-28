package tablestester;

public class DivisionQuestion extends Question {
	public DivisionQuestion(int value, int table) {
		super( table * value + " divided by " + table  + " = ", value);
	}

}
