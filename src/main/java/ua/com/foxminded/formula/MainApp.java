package ua.com.foxminded.formula;

import java.io.File;
import java.io.IOException;
import java.util.List;


public class MainApp {
   public static void main(String[] args) throws IOException {

       FileReader fileReader = new FileReader();

       File start_file = new File("src/main/resources/start.log");
       File end_file = new File("src/main/resources/end.log");
       File abbreviations_file = new File("src/main/resources/abbreviations.txt");


       List<String>start_log_file = fileReader.read(start_file);
       List<String>end_log_file = fileReader.read(end_file);
       List<String>abbreviation_file = fileReader.read(abbreviations_file);



       RacerBuilder racerBuilder = new RacerBuilder();
       List<Racer>kkk = racerBuilder.createRacers(start_log_file,end_log_file,abbreviation_file );


      RacerFormatter formatter = new RacerFormatter();
      formatter.formatted(kkk);

   }
}
