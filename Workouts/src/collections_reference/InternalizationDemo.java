package collections_reference;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Locale;
import java.util.ResourceBundle;

public class InternalizationDemo {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println(Locale.getDefault());
		Locale local = new Locale("ta");
		ResourceBundle rb = ResourceBundle.getBundle("dictionary",local);
		String hello = rb.getString("hello");
		System.out.println(hello);
		
		FileWriter fow = new FileWriter("abc.html",Charset.forName("UTF-8"));
		fow.write(hello);
		fow.close();
		
		
	}

}
