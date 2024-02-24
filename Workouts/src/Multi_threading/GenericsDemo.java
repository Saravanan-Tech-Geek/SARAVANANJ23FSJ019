package Multi_threading;

public class GenericsDemo {
	public static void main(String[] args) {
		/*
		 * T - type E - Elements K - key V - Value
		 */
		PaintBrush<RedPaint1> brush = new PaintBrush<>();
		brush.setObj(new RedPaint1());
		
		PaintBrushBad badbrush = new PaintBrushBad();
		badbrush.setObj(new String());
		Paint1 paint = (Paint1)badbrush.getObj();
		System.out.println(paint);
	}
}

class PaintBrushBad {
	Object obj;

	public void setObj(Object obj) {
		this.obj = obj;
	}

	public Object getObj() {
		return this.obj;
	}
}

class Paint1 {
}

class RedPaint1 extends Paint1 {
}

class BluePaint1 extends Paint1 {
}

class PaintBrush<T> {
	T obj;

	public void setObj(T obj) {
		this.obj = obj;
	}

	public T getObj() {
		return this.obj;
	}
}
