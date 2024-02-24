package basics;

public class AbstractDemo3 {
	public static void main(String[] args) {
		FriedChicken1 chicken=new KFC1();
		
		chicken.doKFCBusiness();
	}
}
//IIT is creating
interface FriedChicken1{
	private void engineeredChicken() {
		System.out.println("chicked is breeded as per the research...");
	}
	private void engineeredMasala() {
		System.out.println("masala is created as per the research");
	}
	private void cookChicken() {
		System.out.println("chicken is cooked as per the research...");
	}
	private void makingProcess() {//template method
		engineeredChicken();
		cookChicken();
		engineeredMasala();
	}
	private void shopDesign() {
		System.out.println("shop design as per research...");
	}
	private void sellStrategy() {
		System.out.println("sell chicken as per research...");
	}
	default public void doKFCBusiness() {//template method
		shopDesign();
		makingProcess();
		sellStrategy();
		collectMoney();
		deliverItems();
	}
	public void collectMoney();
	public void deliverItems();
	
}
class KFC1 implements FriedChicken1{
@Override
	public void collectMoney() {
		System.out.println("collect money as KFC standards...");
	}
@Override
	public void deliverItems() {
		System.out.println("deliver chicken as per franchisee standards....");		
	}
}







