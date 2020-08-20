package ua.com.foxminded.formula;

import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.format.DateTimeParseException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.MissingFormatWidthException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RacerFormatterTest {

    private final RacerFormatter racerFormatter = new RacerFormatter();

    @Test
    void formatShouldReturnFormattedStringAsExcepted() {
        Racer racer = new Racer("Daniel Ricciardo", "RED BULL RACING TAG HEUER", Duration.parse("PT15M"));
        String excepted = " 1.Daniel Ricciardo|RED BULL RACING TAG HEUER|00:15\r\n";
        List<Racer> list = Arrays.asList(racer);
        String actual = racerFormatter.format(list);
        assertEquals(excepted, actual);
    }

    @Test
    void formatShouldThrowsMissingFormatWidthExceptionIfArg() {
        Racer racer = new Racer("", "", Duration.parse("PT15M"));
        List<Racer> list = Arrays.asList(racer);
        assertThrows(MissingFormatWidthException.class, () -> racerFormatter.format(list));
    }

    @Test
    void formatShouldThrowsDateTimeParseException() {
        Racer racer = new Racer("Daniel Ricciardo", "RED BULL RACING TAG HEUER", null);
        List<Racer> list = Collections.singletonList(racer);
        assertThrows(NullPointerException.class, () -> racerFormatter.format(list));
    }

}