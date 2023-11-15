package input_output_stream;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;

public class FileInputOutputDemo2 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		File file = new File("mytext.txt");
		FileReader fr = new FileReader(file);
		FileWriter fw = new FileWriter("fileWrite.txt");
		
		int n = 0 ;
		int optimum = 8;
		char c[] = new char[optimum];
		while((n = fr.read(c))!= -1) {
			String s = new String(c,0,n);
			System.out.print(s);
			fw.write(c,0,n);
		}
		fw.close();
		fr.close();
	}

}
