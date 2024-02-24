package basics;

public class AbstractDemo2 {
	public static void main(String[] args) {
		FriedChicken chicken=new KFC();
		
		chicken.doKFCBusiness();
	}
}
//IIT is creating
abstract class FriedChicken{
	final private void engineeredChicken() {
		System.out.println("chicked is breeded as per the research...");
	}
	final private void engineeredMasala() {
		System.out.println("masala is created as per the research");
	}
	final private void cookChicken() {
		System.out.println("chicken is cooked as per the research...");
	}
	final private void makingProcess() {//template method
		engineeredChicken();
		cookChicken();
		engineeredMasala();
	}
	final private void shopDesign() {
		System.out.println("shop design as per research...");
	}
	final private void sellStrategy() {
		System.out.println("sell chicken as per research...");
	}
	final public void doKFCBusiness() {//template method
		shopDesign();
		makingProcess();
		sellStrategy();
		collectMoney();
		deliverItems();
	}
	public abstract void collectMoney();
	public abstract void deliverItems();
	
}
class KFC extends FriedChicken{
@Override
	public void collectMoney() {
		System.out.println("collect money as KFC standards...");
	}
@Override
	public void deliverItems() {
		System.out.println("deliver chicken as per franchisee standards....");		
	}
}










