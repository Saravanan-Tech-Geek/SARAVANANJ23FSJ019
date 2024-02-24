package basics;

public class ClassesDemo1 {
	public static void main(String[] args) {
		new BataShoeFactory(10);//this created a anonymous object
		BataShoeFactory obj=new BataShoeFactory();//creates a named object - obj is the name
	}
}
class BataShoeFactory{
	//1. constructor 2. properties 3. methods 4. inner classes
	public BataShoeFactory() {
		System.out.println("bata shoe factory is called...");
	}
	public BataShoeFactory(int i) {//constructor overloading
		System.out.println("bata shoe factory is called................"+i);
	}
	/*
	 * properties are of 3 types
	 * 1. instance - if a variable is declared outside methods and construtor - then it is instance
	 * 2. class - if a variable is declared as STATIC then it is class variable
	 * 3. local - if a variable is declared inside a method - it is local variable
	 * declaring a variable with four types is called PRIMITIVE VARIABLES - byte,short,long,int,char,float
	 * declaring a variable with our user defined class is called COMPLEX VARIABLE
	 */
	//PRIMITIVE TYPES
	int i=10;//instance variable
	static int x=10;//class variable
	void met() {
		int y=10;//local variable
	}
	Bank b;//complex type
}
/*
 * animal,shoe,table,chair,bed,mirror,shoefactory-common nouns - ABSTRACT CLASSES
 * lion,tiger,diningtable,easychai,cusionbed,dressingmirror,batashoefactory - proper nouns - CLASSES
 * hunter,seller,doctor,teacher,driver,begger,engineer,barber,student - action nouns - INTERFACES
 *
 * StateBank - proper noun - class whose objects can be created
 * Bank - common noun - abstract class whose child objects only can be created
 * Teller - action noun - define the rules of the role
 *
 *
 */
abstract class Bank{
	
}
class StateBank extends Bank implements Teller{//state bank is a kind of bank and playing the role of teller
	
}
interface Teller{
	
}