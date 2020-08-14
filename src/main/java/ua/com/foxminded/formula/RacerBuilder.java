package ua.com.foxminded.formula;

import java.time.Duration;
<<<<<<< HEAD
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
=======
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
>>>>>>> a907ad6eceb685b190445e7e5ccd865b296d3374
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

public class RacerBuilder {
    public List<Racer> createRacers(List<String>start, List<String>end, List<String>abbreviation){

        List<Racer>result = new LinkedList<>();
        String abrv;
        String name;
        String team;
        String startLap = null;
        String endLap = null;
        Duration lapTime;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss.SSS");

        for(int i =0;i < start.size();i++){
            abrv = abbreviation.get(i).split("_")[0];
            name = abbreviation.get(i).split("_")[1];
            team = abbreviation.get(i).split("_")[2];

            for(String time : start) {
                if (time.contains(abrv)) {
                    startLap = time.split("_")[1];
                    break;
                }
            }
            for(String time : end) {
                if (time.contains(abrv)) {
                    endLap = time.split("_")[1];
                    break;
                }
            }

<<<<<<< HEAD
            LocalTime startTime = LocalTime.parse(startLap,formatter);
            LocalTime endTime = LocalTime.parse(endLap,formatter);
=======
            LocalTime startTime = LocalTime.parse(start_lap,formatter);
            LocalTime endTime = LocalTime.parse(end_lap,formatter);
>>>>>>> a907ad6eceb685b190445e7e5ccd865b296d3374

            lapTime = Duration.between(startTime,endTime);

            Racer racerBuilder = new Racer(name,team,lapTime);
            result.add(racerBuilder);

        }
        return result;
    }
}
