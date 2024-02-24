package input_output_stream;

import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class FileChannelDemo {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		Path path = Paths.get("fileWrite.txt");
		
		FileChannel channel = FileChannel.open(path, StandardOpenOption.READ);
		
		int byteReads = 0;
		
		ByteBuffer buffer = ByteBuffer.allocate(8);
		
		while((byteReads = channel.read(buffer)) != -1) { //data is written in the buffer
			buffer.flip(); // this flip is to make the buffer now to read
			byte[] b = new byte[byteReads];
			buffer.get(b); //will write the contents of the buffer to the byte array
			String content = new String(b); //this will convert the byte array to string
			System.out.println(content);
		}
		
		
	}

}
