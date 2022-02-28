package tablestester;

public class Question {
	protected String question;
	protected int correctAnswer;
	protected boolean incorrect;
	
	public Question(String question, int correctAnswer) {
		super();
		this.question = question;
		this.correctAnswer = correctAnswer;
	}

	public boolean isIncorrect() {
		return incorrect;
	}

	public void setIncorrect(boolean incorrect) {
		this.incorrect = incorrect;
	}
	
}
