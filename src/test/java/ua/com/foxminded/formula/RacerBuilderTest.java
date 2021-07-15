package ua.com.foxminded.formula;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RacerBuilderTest {
/*
    static RacerBuilder racerBuilder = new RacerBuilder();

    @Test
    void createRacersShouldThrowsNullExceptionIfAnyArgIsNull() {
        assertThrows(NullPointerException.class,()->racerBuilder.createRacers(null,null,null));
    }

    @Test
    void createRacersShouldReturnEmptyListIfArgListIsEmpty() {
        List<String>start = new ArrayList<>();
        List<String>end = new ArrayList<>();
        List<String>abbr = new ArrayList<>();
        List<Racer>expected = new LinkedList<>();

        assertEquals(expected,racerBuilder.createRacers(start,end,abbr));
    }

    @Test
    void createRacersShouldThrowsBoundsExceptionIfAnyArgHaveDifferentLength(){
        List<String>start = new ArrayList<>(Arrays.asList("one","two"));
        List<String>end = new ArrayList<>(Arrays.asList("one"));
        List<String>abbr = new ArrayList<>(Arrays.asList("one","two"));

        assertThrows(ArrayIndexOutOfBoundsException.class,()->racerBuilder.createRacers(start,end,abbr));
    }

    @Test
    void createRacersShouldThrowsBoundsExceptionIfArraysIsEmpty(){
        List<String>start = new ArrayList<>(Arrays.asList(""));
        List<String>end = new ArrayList<>(Arrays.asList(""));
        List<String>abbr = new ArrayList<>(Arrays.asList(""));

        racerBuilder.createRacers(start,end,abbr);

        assertThrows(ArrayIndexOutOfBoundsException.class, ()->racerBuilder.createRacers(start,end,abbr));

    }

    @Test
    void createRacersShouldReturnListWithStringByExcepted(){
        List<String>start = new ArrayList<>(Arrays.asList("DRR2018-05-24_12:14:12.054"));
        List<String>end = new ArrayList<>(Arrays.asList("DRR2018-05-24_12:15:24.067"));
        List<String>abbr = new ArrayList<>(Arrays.asList("DRR_Daniel Ricciardo_RED BULL RACING TAG HEUER"));

        String excepted = "[Racer{name='Daniel Ricciardo', team='RED BULL RACING TAG HEUER', lapTime=PT1M12.013S}]";
        String actual = racerBuilder.createRacers(start,end,abbr).toString();
        assertEquals(excepted,actual);

    }

*/
}