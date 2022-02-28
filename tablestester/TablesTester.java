package tablestester;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import javax.sound.sampled.AudioInputStream;


public class TablesTester  {
	Scanner sc = new Scanner(System.in);
	AudioInputStream audioStream; 
	


	List<Integer> tables = Arrays.asList(new Integer[] { 9 });
	boolean multiplication = true;
	boolean division = true;
	boolean addition = false;
	boolean subtraction = false;
	
	
	

	public static void main(String args[]) throws Exception {
		new TablesTester();

	}
	
	
	private TablesTester() {
		List<Question> questions = new ArrayList<Question>();

		tables.forEach(t -> {
			for (int i = 1; i < 13; i++) {
				if (multiplication) {
					questions.add(new MultiplicationQuestion(i, t));
				}
				if (division) {
					questions.add(new DivisionQuestion(i, t));
				}
				if (addition) {
					questions.add(new AdditionQuestion(i, t));
				}
				if (subtraction) {
					questions.add(new SubtractionQuestion(i, t));
				}
			}
		});
		Collections.shuffle(questions);
		runIt(questions);

	}
	
	private void runIt(List<Question> questions) {
		
		questions.forEach(q -> askQuestion(q));
		List<Question> wronguns = questions.stream().filter(Question::isIncorrect).collect(Collectors.toList());

		if (wronguns.size() > 0) {
			System.out.println("You got " + wronguns.size() + " wrong: ");
			runIt(wronguns);
		} else {
			System.out.println("All Correct!");
			new Klaxon().playSound("resources/applause.wav");
		}
	}

	private void askQuestion(Question question) {
		System.out.println(question.question);
		Integer answer = getAnswer();
		if (question.correctAnswer == answer) {
			System.out.println("Correct!");
			question.setIncorrect(false);
			new Klaxon().playSound("resources/Glass.wav");
		} else {
			System.out.println("WRONG !!");
			new Klaxon().playSound("resources/klaxon.wav");
			System.out.println("Should have said " + question.correctAnswer);
			question.setIncorrect(true);
		}
	}
	
	private Integer getAnswer() {
		String answer = sc.nextLine();
		Integer ret = null;
		try {
			ret = Integer.parseInt(answer);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			System.out.println("Enter a number, dufus!");
			return getAnswer();
		}
		return ret;
	}


}
