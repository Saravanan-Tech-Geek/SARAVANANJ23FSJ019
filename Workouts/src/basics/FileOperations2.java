package basics;

import java.io.FileReader;
import java.io.FileWriter;

public class FileOperations2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try(
				FileReader fir=new FileReader("mytext.txt");
				FileWriter fiw=new FileWriter("copy2.txt");
				){
				//System.out.println((char)fir.read());
				
				int x=0;
				char c[]=new char[4];
				while((x=fir.read(c))!=-1) {
					String s=new String(c,0,x);
					System.out.println(s);
					fiw.write(c,0,x);
				}
				}catch(Exception e) {e.printStackTrace();}
	}

}
