package com.assignment;

public class InterfaceSam {
	public static void main(String[] args) {
		X.QuestionY c = new X.QuestionY(1);
		System.out.println(c.disp());
	}
}
interface X{
	class QuestionY{
		int i;
	QuestionY(int i){
		this.i=++i;
	}
	int disp() {
		return ++i;
	}
	}
	
}