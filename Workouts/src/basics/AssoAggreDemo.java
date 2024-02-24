package basics;

public class AssoAggreDemo {
	public static void main(String[] args) {
		IndianPlug anand=new IndianPlug();
		IndianSocket sakthi=new IndianSocket();
		sakthi.roundPin(anand);
		AmericanPlug dell=new AmericanPlug();
		IndianAdapter ia=new IndianAdapter();
		ia.set(dell);
		sakthi.roundPin(ia);
	}
}
class IndianPlug{
	public void execute() {
		System.out.println("indian plug working....");
	}
}
class IndianSocket{
	public void roundPin(IndianPlug ip) {//indian plug is part of indian socket
		ip.execute();
	}
}
class AmericanPlug{
	public void execute() {
		System.out.println("American Plug Works.....");
	}
}
class IndianAdapter extends IndianPlug{
	AmericanPlug ap;
	public void set(AmericanPlug ap) {
		this.ap=ap;
	}
	public void execute() {
		ap.execute();
	}
}







