package basics;

public class ClassDemo2 {
	public static void main(String[] args) {
		Laddu laddu=new Laddu();
		System.out.println("size of laddu..:"+laddu.size);
		PbvPbr obj=new PbvPbr();
		
		System.out.println("Before PBV..:"+laddu.size);
		obj.pbv(laddu.size);//pass by value - a copy of the primitive variable is supplied as argument
		System.out.println("After PBV..:"+laddu.size);//value wont change - 10;
		System.out.println("Before PBR..:"+laddu.size);
		obj.pbr(laddu);//pass by Reference -the original laddu is supplied as argument
		System.out.println("After PBR..:"+laddu.size);//original value will change - 5;
	}
}
//PASS BY VALUE AND PASSY BE REFERENCE
class Laddu{
	int size=10;
}
class PbvPbr{
	public void pbv(int size) {
		size=5;
	}
	public void pbr(Laddu myladdu) {
		myladdu.size=5;
	}
}






