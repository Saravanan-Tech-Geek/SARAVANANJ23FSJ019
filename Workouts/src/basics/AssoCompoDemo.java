package basics;
// Decorator pattern
// Composition pattern - whole of
public class AssoCompoDemo {
	public static void main(String[] args) {
		IceCreamItem ic=new Vanila(new Fruits(new StrawBerry(new Nuts(new Vanila()))));
		System.out.println(ic.taste());
	}
}
class IceCreamItem{
	public String taste() {return "base taste";}
}
class Cream extends IceCreamItem{
	
}
class Vanila extends Cream{
	IceCreamItem ic;
	public Vanila() {
		// TODO Auto-generated constructor stub
	}
	public Vanila(IceCreamItem ic) {
		this.ic=ic;
	}
	public String taste() {
		if(ic!=null) {
			return ("vanila...:"+ic.taste());
		}else {
			return "only vanila...";
		}
	}
}
class StrawBerry extends Cream{
	IceCreamItem ic;
	public StrawBerry() {
		// TODO Auto-generated constructor stub
	}
	public StrawBerry(IceCreamItem ic) {
		this.ic=ic;
	}
	public String taste() {
		if(ic!=null) {
			return ("Strawberry...:"+ic.taste());
		}else {
			return "only strawberry...";
		}
	}
}
class Topup extends IceCreamItem{
	
}
class Nuts extends Topup{
	IceCreamItem ic;
	public Nuts() {
		// TODO Auto-generated constructor stub
	}
	public Nuts(IceCreamItem ic) {
		this.ic=ic;
	}
	public String taste() {
		if(ic!=null) {
			return ("Nuts...:"+ic.taste());
		}else {
			return "only nuts....";
		}
	}
}
class Fruits extends Topup{
	IceCreamItem ic;
	public Fruits() {
		// TODO Auto-generated constructor stub
	}
	public Fruits(IceCreamItem ic) {
		this.ic=ic;
	}
	public String taste() {
		if(ic!=null) {
			return ("Fruits...:"+ic.taste());
		}else {
			return "only fruits...";
		}
	}
}










