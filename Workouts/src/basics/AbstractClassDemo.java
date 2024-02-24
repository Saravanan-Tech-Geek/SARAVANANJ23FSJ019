package basics;

public class AbstractClassDemo {
	public static void main(String[] args) {
		Table table1=new DiningTable();
		Table table2=new DrawingTable();
		Table table3=new StudyTable();
		table1.met();
		table2.met();
		table3.met();
		
	}
}
abstract class Table{
	public Table() {
		System.out.println("cons called...");
	}
	final public void met() {
		System.out.println("met called...");
	}
	abstract void meet();
}
class DiningTable extends Table{
	
	@Override
	void meet() {
		// TODO Auto-generated method stub
		
	}
}
class DrawingTable extends Table{

	@Override
	void meet() {
		// TODO Auto-generated method stub
		
	}
	
}
class StudyTable extends Table{

	@Override
	void meet() {
		// TODO Auto-generated method stub
		
	}
	
}









