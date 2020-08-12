package ua.com.foxminded.formula;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileReader {

    public List<String> read(File file) throws IOException {
        checkFile(file);
        Stream<String>stream = Files.lines(Paths.get(file.getAbsolutePath()));
        return stream.collect(Collectors.toList());
    }

    private void checkFile(File file){
        if (file==null){
            throw new IllegalArgumentException("the file can't be null");
        }
        if (!file.exists()){
            throw new IllegalArgumentException(file.getName()+" dos't exist");
        }
        if (!file.canRead()){
            throw new IllegalArgumentException(file.getName()+ " can't be read");
        }


    }


}
