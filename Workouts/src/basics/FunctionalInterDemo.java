package basics;

public class FunctionalInterDemo {
	public static void main(String[] args) {
		//CampaCola cc=new Bovonto().new CampaColaImpl();//access inner class
		//CampaCola cc=new Bovonto.CampaColaImpl();//access static inner class
		Bovonto bovonto=new Bovonto();
		PepsiCo pepsi=new PepsiCo();
		
		bovonto.sellCola(null);
		//pepsi.sellCola(null);
	}
}
interface CampaCola{
	public void makeCola();
}
class Bovonto {
	public void sellCola(CampaCola cc) {
		//anonymous inner class
		new CampaCola() {			
			@Override
			public void makeCola() {
				System.out.println("cola made as per campa cola logic.using anonymous..");		
			}
		}.makeCola();
		
		//Lambda
		CampaCola ccc=()->{System.out.println("cola made as per campa cola logic.using lambda..");};
		ccc.makeCola();
		//Method Referencing
		CampaCola cm=Bovonto::makeColaLogicCopies;
		cm.makeCola();
		System.out.println("fill in bovonto bottle and sell cola...");
	}
	public static void makeColaLogicCopies() {
		System.out.println("cola logic copied and made cola...method referencing");
	}
//	static class CampaColaImpl implements CampaCola{//acquisition
//		@Override
//		public void makeCola() {
//			System.out.println("campa cola creates cola....");
//		}
//	}
}
class PepsiCo{
	public void sellCola(CampaCola cc) {
		cc.makeCola();
		System.out.println("fill in pepsi bottle and sell cola..");
	}
}







