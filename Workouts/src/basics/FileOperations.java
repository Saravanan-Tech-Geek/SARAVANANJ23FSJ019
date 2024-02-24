package basics;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FileOperations {

	public static void main(String[] args) throws Exception {
		FileInputStream fis = new FileInputStream("mytext.txt");
		FileOutputStream fos=new FileOutputStream("copy.txt");
		System.out.println(fis.available());
		//System.out.println((char)fis.read());
		
		int x = 0;
		byte[] b = new byte[4];
		while((x = fis.read(b))!= -1) {
//			System.out.print((char)x);
			System.out.println("Number of bytes read"+ x);
			String s = new String(b,0,x);
			System.out.println(s);
			fos.write(b,0,x);
		}
		
	}

}
