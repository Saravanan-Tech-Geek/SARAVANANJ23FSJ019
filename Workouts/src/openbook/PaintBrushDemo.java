package openbook;

public class PaintBrushDemo {
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		GoodPaintBrush brush = new GoodPaintBrush();
		brush.p = new RedPaint();
		brush.p = new BluePaint();

		GoodGoodPaintBrush<Water> brushgood = new GoodGoodPaintBrush<>();
		brushgood.setObj(new Water());
		Water w = brushgood.getObj();

		GoodGoodPaintBrush<Paint> brushgood2 = new GoodGoodPaintBrush<>();
		brushgood2.setObj(new RedPaint());
		Paint p = brushgood2.getObj();

		GoodGoodPaintBrushDoubtfull brushdoubt = new GoodGoodPaintBrushDoubtfull();
		brushdoubt.setObj(new Water());

		brushdoubt.setObj(new RedPaint());
		
		Water sw = (Water) brushdoubt.getObj();
		System.out.println(sw);
	}
}

/*
 * Advantages of Inheritance 1. Code Reusability 2. Object Reusability 3.
 * Part-Whole hierarchy 4. Composition 5. Polymorphic query 6. Removal of
 * if-else-if conditions.
 */
class GoodGoodPaintBrushDoubtfull {
	Object obj;

	public void setObj(Object obj) {
		this.obj = obj;
	}

	public Object getObj() {
		return this.obj;
	}
}

class GoodGoodPaintBrush<T> {
	T obj;

	public void setObj(T obj) {
		this.obj = obj;
	}

	public T getObj() {
		return this.obj;
	}
}

class Water {

}

class DryAir {

}

class BadPaintBrush {// CODE IS OPEN FOR MODIFICATION - BECAUSE IT CONTAINS IF-ELSE-IF LADDER
	public void doPaint(int i) {
		if (i == 1) {
			System.out.println("red paint...");
		} else if (i == 2) {
			System.out.println("blue paint..");
		}
	}
}

/*
 * We eliminated the if-else-if ladder using the thumb rule 1. Convert the
 * condition to classes 2. Group them under a hierarchy 3. Create a Association
 * between the using class and Hierarchial class.
 */
class GoodPaintBrush {
	Paint p;
}

abstract class Paint {

}

class RedPaint extends Paint {

}

class BluePaint extends Paint {

}