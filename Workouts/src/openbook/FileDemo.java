package openbook;

import java.io.FileReader;
import java.io.IOException;

public class FileDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Try with resource
		try (FileReader fs = new FileReader("c:/sample.txt")) {
			System.out.println("Sample try");
		} catch (IOException e) {

		}
	}

	public void send() {
		FileReader f = null;
		try {
			f = new FileReader("c:/data.txt");
		} catch (Exception e) {
			System.out.println("Exception!!");
		} finally {
			try {
				f.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
