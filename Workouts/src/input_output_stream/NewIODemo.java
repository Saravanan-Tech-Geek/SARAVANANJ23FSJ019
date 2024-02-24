package input_output_stream;

import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NewIODemo {
	public static void main(String[] args) throws Exception{
		Path path=Paths.get("newfile.txt");				
		ExecutorService es=Executors.newFixedThreadPool(2);
		es.execute(()->{
			String data = "Hello, this is an example of NIO file writing with Buffer and Channel.";
	        try (FileChannel channel = FileChannel.open(path, StandardOpenOption.CREATE,
	        		StandardOpenOption.WRITE)) {
	            // Convert the data to bytes
	        	System.out.println("writing called...");
	        	int count=0;
	        	byte []dataBytes=null;
	        	while(count<data.length()) {
	        		if(data.length()-count<8) {
	        			dataBytes = data.substring(count,data.length()).getBytes();
	        		}
	        		else {
	        			dataBytes = data.substring(count,count+8).getBytes();
	        		}
	           
	            // Create a ByteBuffer
	            ByteBuffer buffer = ByteBuffer.allocate(8);
	            buffer.put(dataBytes);
	           
	            // Flip the buffer to prepare for writing
	            buffer.flip();
	           
	            // Write the buffer to the channel
	            channel.write(buffer);
	           
	            System.out.println("File written successfully.");
	            count=count+8;
				Thread.sleep(4000);
	        	}
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
		});
		es.execute(()->{
			try {
				System.out.println("reading called...");
			FileChannel channel=FileChannel.open(path, StandardOpenOption.READ);
			int bytesread=0;
			ByteBuffer buffer=ByteBuffer.allocate(2000);
			while(true) {				
			while((bytesread=channel.read(buffer))!=-1) {//the data is written in the buffer				
				//Thread.sleep(2000);
				buffer.flip();//this flip is to make the buffer now to read
				byte b[]=new byte[bytesread];
				buffer.get(b);//will write the contents of the buffer to the byte array
				String content=new String(b);//this will convert the byte array to string
				System.out.println(content);	
			}
			}
				
			}catch(Exception e) {
				e.printStackTrace();
			}
		});
		
		es.shutdown();
		
		
	}
}