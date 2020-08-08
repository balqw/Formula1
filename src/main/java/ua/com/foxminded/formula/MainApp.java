package ua.com.foxminded.formula;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws IOException, URISyntaxException {



      Parser r = new Parser();
      List<String>k=r.read();


      for(String s:k){
          System.out.println(s);
      }


       }

}
