package input_output_stream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FileInputOutputDemo1 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		File file = new File("mytext.txt");
		System.out.println(file.isFile());
		System.out.println(file.isDirectory());
		System.out.println(file.getAbsolutePath());
		System.out.println(file.getPath());

		FileInputStream fis = new FileInputStream(file);
		FileOutputStream fos = new FileOutputStream("myOutputFile.txt",true); // true we are making the
		// output file to append text instead of overriding the text.

		//System.out.println((char) fis.read());
		//System.out.println((char) fis.read());

		System.out.println(fis.available());

		// Since fis.available value deprecate , its not the right approach
//		for(int i = 0 ; i < fis.available();i++) {
//			System.out.print((char)fis.read());
//		}

		int n = 0;
		// normal way to read a file
//		while ((n = fis.read()) != -1) {
//			System.out.print((char)n);
//		}
		
		// alternate way - but all time we need to go with full size
//		byte b[] = new byte[fis.available()];
//		while((n = fis.read(b)) != -1) {
//			String s = new String(b);
//			System.out.print(s);
//		}
		
		//  optimized way
		int optimized = 8;
		byte b[] = new byte[optimized];
		while((n = fis.read(b)) != -1) {
			String s = new String(b,0,n);
			System.out.print(s); //writing to console
			fos.write(b,0,n);
		}
		
		fis.close();
		fos.close();
		
	}

}
