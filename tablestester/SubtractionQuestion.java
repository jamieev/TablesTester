package tablestester;

public class SubtractionQuestion extends Question {
	public SubtractionQuestion(int value, int table) {
		super( table + value + " - " + table  + " = ", value);
	}
}
