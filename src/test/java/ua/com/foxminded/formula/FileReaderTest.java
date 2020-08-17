package ua.com.foxminded.formula;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FileReaderTest {

    private static FileReader fileReader= new FileReader();
    private static File startFile = new File("src/test/resources/test_start.log");
    private static File endFile = new File("src/test/resources/test_end.log");
    private static File abbreviations_file = new File("src/test/resources/test_abbreviations.txt");



    @Test
    void readShouldReturnExceptionIfInputFileIsNull(){

        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
              fileReader.read(null);
            });
        assertEquals("the file can't be null",exception.getMessage());
        }

    @Test
    void readShouldReturnExceptionIfInputFileIsDoesNotExist(){
        Throwable exception = assertThrows(IllegalArgumentException.class, () ->{
            fileReader.read(new File(""));
        });
        assertEquals(" dos't exist",exception.getMessage());
    }

    @Test
    void readShouldReturnListWithStringExpected() throws IOException {
        String expected = "[DRR2018-05-24_12:14:12.054]";
        String result = fileReader.read(startFile).toString();
        assertEquals(expected,result);
    }



}