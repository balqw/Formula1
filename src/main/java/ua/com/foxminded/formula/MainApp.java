package ua.com.foxminded.formula;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;


public class MainApp {
   public static void main(String[] args) throws IOException {

       FileReader fileReader = new FileReader();

       File startFile = new File("src/main/resources/start.log");
       File endFile = new File("src/main/resources/end.log");
       File abbreviations_file = new File("src/main/resources/abbreviations.txt");


       List<String>startLogList = fileReader.read(startFile);
       List<String>endLogList = fileReader.read(endFile);
       List<String>abbreviationList = fileReader.read(abbreviations_file);


       RacerBuilder racerBuilder = new RacerBuilder();
       List<Racer>racers = racerBuilder.createRacers(startLogList,endLogList,abbreviationList );


      RacerFormatter formatter = new RacerFormatter();
       System.out.println(formatter.format(racers));



   }
}
