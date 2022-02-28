package tablestester;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class TablesTester2 {
	Scanner sc = new Scanner(System.in);
	List<Integer> tables = Arrays.asList(new Integer[] { 5 });
	boolean multiplication = false;
	boolean division = false;
	boolean addition = false;
	boolean subtraction = true;

	public static void main(String args[]) {
		new TablesTester2();
		
	}
	
	private TablesTester2() {
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
			System.out.println("You got " + wronguns.size() + " wrong (Shame!): ");
			runIt(wronguns);
		} else {
			System.out.println("All Correct. Less shame!");
		}
	}

	private void askQuestion(Question question) {
		System.out.println(question.question);
		String answer = sc.nextLine();
		if (question.correctAnswer == Integer.parseInt(answer)) {
			System.out.println("Correct!");
			question.setIncorrect(false);
		} else {
			System.out.println("WRONG (SHAME, SHAME!)");
			System.out.println("Should have said " + question.correctAnswer);
			question.setIncorrect(true);
		}

	}
}
