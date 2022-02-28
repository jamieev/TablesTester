package tablestester;

public class MultiplicationQuestion extends Question {

	
	public MultiplicationQuestion(int value, int table) {
		super( table + " x " + value  + " = ", table * value);
	}

}
