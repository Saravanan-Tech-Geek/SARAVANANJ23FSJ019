package com.assignment;

public class StaticExample {
	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		System.out.println(new QuestionNext().x);
	}
}

class QuestionSample {
	static int x;

	static {
		x++;
		System.out.println("Questionsample..: " + x);
	}
	{
		++x;
	}
}

class QuestionNext extends QuestionSample {

	static {
		--x;
		System.out.println("QuestionNext..: "+ x);
	}
	{
		x--;
	}
}