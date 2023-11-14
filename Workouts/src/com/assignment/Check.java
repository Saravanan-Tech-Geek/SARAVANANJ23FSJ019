package com.assignment;
class Question{
	int i;
	Question(int i){
		this.i = i--;
	}
}
class Question1 extends Question{
	Question1(int i){
		super(++i);
		System.out.print(i);
	}
}
public class Check {

	public static void main(String[] args) {
		new Question1(20);
	}

}
