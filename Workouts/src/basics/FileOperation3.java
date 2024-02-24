package basics;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Properties;

public class FileOperation3 {
    public static void main(String[] args) {
    	  try (
                  FileReader fir = new FileReader("unicode.properties", Charset.forName("UTF-8"));
                  FileWriter fiw = new FileWriter("copy2.html", Charset.forName("UTF-8"));
          ) {
              Properties properties = new Properties();
              properties.load(fir);

              fiw.write("<html><meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" />");

              String textData = properties.getProperty("textdata");
              if (textData != null) {
                  fiw.write(textData);
              }

              fiw.write("</html>");
          } catch (IOException e) {
              e.printStackTrace();
          }
    }
}
