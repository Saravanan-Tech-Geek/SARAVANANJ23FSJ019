package basics;

public class InherDemo1 {
	public static void main(String[] args) {
		ShoeShop shop=new ShoeShop();
		shop.sf=new BataShoeFactory1();
		shop.sf=new LakhaniShoeFactory();
		//shop object is reusable
	}
}
class ShoeShop{//shoeshop a reusable object - can be used for both bata and lakhani
	ShoeFactory sf;//KNOWLEDGE OF - ASSOCIATION
}
class ShoeFactory{
	
}
//GENERALIZATION -KIND OF
class BataShoeFactory1 extends ShoeFactory{//KIND OF RELATIONSHIP-BATASHOEFACTORY IS A KIND OF SHOEFACTORY
	
}
class LakhaniShoeFactory extends ShoeFactory{//KIND OF RELATIONSHIP-BATASHOEFACTORY IS A KIND OF SHOEFACTORY
	
}
//
//package basics;
//public class InherDemo1 {
//	public static void main(String[] args) {
//		PaintBrush brush=new PaintBrush();
//		brush.sf=new RedPaint();
//		brush.sf=new BluePaint();
//		//brush object is reusable
//	}
//}
//class PaintBrush{//brush a reusable object - can be used for both red and blue paint
//	Paint sf;//KNOWLEDGE OF - ASSOCIATION
//}
//class Paint{
//	
//}
////GENERALIZATION -KIND OF
//class RedPaint extends Paint{//KIND OF RELATIONSHIP-REDPAINT IS A KIND OF PAINT
//	
//}
//class BluePaint extends Paint{//KIND OF RELATIONSHIP-BLUEPAINT IS A KIND OF PAINT
//	
//}
//9:49
//package basics;
///*
// * RELATIONSHIPS
// * 1. ASSOCIATION - KNOWLEDGE OF - PEOPLE HAVE KNOWLEDGE GOLDENTOUCH
// * 2. AGGREGATION - PART OF - STUDENTS ARE PART OF GOLDENTOUCH
// * 3. COMPOSITION - WHOLE OF - SHOIAB IS WHOLE OF GOLDENTOUCH
// * 4. GENERALIZATION - KIND OF - GOLDENTOUCH IS A KIND OF TECHNICAL PROGRAM
// * 5. REALIZATION - REALIZE OF - STUDENT REALIZE THE OBJECTIVE OF LEARNING JAVA THROUGH SHOIAB WHO IS
// * PLAYING THE ROLE OF JAVA TEACHER.
// *
// * 1. ASSOCIATION - HUMAN HAS KNOWLEDGE OF TEA
// * 2. AGGREGATION - SUGAR,MILK,WATER ARE PART OF TEA
// * 3. COMPOSITION - DECATION IS WHOLE OF TEA
// * 4. GENERALIZATION - LIPTON IS A KIND OF TEA
// * 5. REALIZATION - PEOPLE REALIZE TEA THROUGH MOTHER WHO IS PLAYING THE ROLE OF TEA MAKER
// */
//public class InherDemo1 {
//	public static void main(String[] args) {
//		PaintBrush brush=new PaintBrush();
//		brush.sf=new RedPaint();
//		brush.sf=new BluePaint();
//		//brush object is reusable
//	}
//}
//class PaintBrush{//brush a reusable object - can be used for both red and blue paint
//	Paint sf;//KNOWLEDGE OF - ASSOCIATION
//}
//class Paint{
//	
//}
////GENERALIZATION -KIND OF
//class RedPaint extends Paint{//KIND OF RELATIONSHIP-REDPAINT IS A KIND OF PAINT
//	
//}
//class BluePaint extends Paint{//KIND OF RELATIONSHIP-BLUEPAINT IS A KIND OF PAINT
//	
//}
//9:53
//package basics;
//public class AssoDemo {
//	public static void main(String[] args) {
//		/*
//		 * shoiab has knowledge of java
//		 * students are part of golden touch program
//		 * shoiab is whole of GoldenTouch
//		 */
//	}
//}
//class Shoiab{
//	Java java;//knowledge of
//}
//class Java{
//	
//}
//class Student{
//	
//}
//class GoldenTouch{
//	public GoldenTouch(Shoiab s) {//if a variable is added in constructor it is whole of
//		// TODO Auto-generated constructor stub
//	}
//	public void course(Student s) {//part of
//		
//	}
//}
//9:57
//package basics;
//public class AssoDemo {
//	public static void main(String[] args) {
//		/*
//		 * shoiab has knowledge of java
//		 * students are part of golden touch program
//		 * shoiab is whole of GoldenTouch
//		 */
//	}
//}
//class IRCTC{
//	public IRCTC(Railways r) {//railways is whole of IRCTC
//		// TODO Auto-generated constructor stub
//	}
//	Train t;//irctc has knowledge of trains
//	public void booking(Passenger p) {//passenger is part of booking process
//		
//	}
//}
//class Train{
//	public void journey(Passenger p) {//
//		
//	}
//}
//class Passenger{
//	Train t;//knowledge of
//}
//class Railways{
//	public Railways(Train t) {//if a variable is added in constructor it is whole of
//		// TODO Auto-generated constructor stub
//	}
//	public void booking(IRCTC i) {//part of
//		
//	}
//}
//
//package basics;
//public class AssoDemo {
//	public static void main(String[] args) {
//		/*
//		 * shoiab has knowledge of java
//		 * students are part of golden touch program
//		 * shoiab is whole of GoldenTouch
//		 */
//	}
//}
//class Government{
//	public void department(GovernmentStaff gs) {//staff is part of government
//		
//	}
//}
//class GovernmentStaff{
//	public GovernmentStaff(Government g) {//government is whole of government staff
//		// TODO Auto-generated constructor stub
//	}
//}
//class Broker{
//	Government t;//knowledge of
//}
//class Public{
//	Government g;//public has knowledge of government
//}