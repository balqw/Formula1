package ua.com.foxminded.formula;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Parser {
    public Path pathToAbbreviations = Paths.get(Objects.requireNonNull(this.getClass().getClassLoader().getResource("abbreviations.txt")).toURI());
    public Path pathToStart = Paths.get(Objects.requireNonNull(this.getClass().getClassLoader().getResource("start.log")).toURI());
    public Path pathToEnd = Paths.get(Objects.requireNonNull(this.getClass().getClassLoader().getResource("end.log")).toURI());

    public Parser() throws URISyntaxException, IOException {
    }

    public  List<String> read(Path path) throws IOException, URISyntaxException {

        return Files.lines(Paths.get(String.valueOf(path)))
                .collect(Collectors.toList());
    }

    List<String>abbreviations = read(pathToAbbreviations);
    List<String>start_log = read(pathToStart);
    List<String>end_log = read(pathToEnd);


}
