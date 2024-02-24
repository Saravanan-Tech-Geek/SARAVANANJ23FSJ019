package basics;

public class AssoAggreDemo2 {
}
class Pepsi{
	//Cola cola;//knowledge of cola company
	//public void makeCola() {
	//	cola.makeCola();
	//}
}
class Kalimark{
	Cola cola;//knowledge of cola company
	public void makeCola() {
		cola.makeCola();
	}
	class Cola{//Cola class is part of Kalimark - acquisition
		public void makeCola() {
			System.out.println("cola made by cola company....");
		}
	}
}






