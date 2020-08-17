package ua.com.foxminded.formula;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.lang.reflect.Array;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RacerFormatterTest {
    private Racer racer = new Racer("Daniel Ricciardo","RED BULL RACING TAG HEUER",Duration.parse("PT15M"));
    private RacerFormatter racerFormatter = new RacerFormatter();
    List<Racer>list = new ArrayList<>(Arrays.asList(racer));

    @Test
            void sds(){
        String excepted = " 1.Daniel Ricciardo|RED BULL RACING TAG HEUER|00:15\r\n";
        String actual = racerFormatter.format(list);
        assertEquals(excepted,actual);
    }




}