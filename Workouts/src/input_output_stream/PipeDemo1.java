package input_output_stream;

import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PipeDemo1 {
	public static void main(String[] args) throws Exception {
		PipedInputStream pis = new PipedInputStream();
		PipedOutputStream pos = new PipedOutputStream();

		pis.connect(pos);

		ExecutorService es = Executors.newFixedThreadPool(2);
		
		es.execute(()->{
			try {
			pos.write(97);
			pos.write(98);
			Thread.sleep(5000);
			pos.write(99);
			}catch(Exception e) {
				e.printStackTrace();
			}
		});
		
		es.execute(()->{
			try {
				System.out.println((char)pis.read());
				System.out.println((char)pis.read());
				System.out.println((char)pis.read());
				}catch(Exception e) {
					e.printStackTrace();
				}
		});
		
		es.shutdown();
	}
}
