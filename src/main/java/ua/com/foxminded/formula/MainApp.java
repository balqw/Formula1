package ua.com.foxminded.formula;

import java.io.File;
import java.io.IOException;

import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MainApp {
   public static void main(String[] args) throws IOException, URISyntaxException {

       FileReader fileReader = new FileReader();

       File start_file = new File("src/main/resources/start.log");
       File end_file = new File("src/main/resources/end.log");
       File abbreviations_file = new File("src/main/resources/abbreviations.txt");


       List<String>start_log_file = fileReader.read(start_file);
       List<String>end_log_file = fileReader.read(end_file);
       List<String>abbreviation_file = fileReader.read(abbreviations_file);

       for(String s : start_log_file){
           System.out.println(s);
       }
       System.out.println("\n");

       for(String s : end_log_file){
           System.out.println(s);
       }
       System.out.println("\n");

       for(String s : abbreviation_file){
           System.out.println(s);
       }
   }
}
