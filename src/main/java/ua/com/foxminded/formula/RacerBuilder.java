package ua.com.foxminded.formula;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

public class RacerBuilder {
    public List<Racer> createRacers(List<String>start, List<String>end, List<String>abbreviation){

        List<Racer>result = new LinkedList<>();
        String abrv;
        String name;
        String team;
        String start_lap = null;
        String end_lap = null;
        Duration lapTime;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss.AAA");

        for(int i =0;i < start.size()-1;i++){
            abrv = abbreviation.get(i).split("_")[0];
            name = abbreviation.get(i).split("_")[1];
            team = abbreviation.get(i).split("_")[2];

            for(String time : start) {
                if (time.contains(abrv)) {
                    start_lap = time.split("_")[1];
                    break;
                }
            }
            for(String time : end) {
                if (time.contains(abrv)) {
                    end_lap = time.split("_")[1];
                    break;
                }
            }

            LocalTime startTime = LocalTime.parse(start_lap,formatter);
            LocalTime endTime = LocalTime.parse(end_lap,formatter);

            lapTime = Duration.between(startTime,endTime);

            Racer racerBuilder = new Racer(name,team,lapTime);
            result.add(racerBuilder);

        }
        return result;
    }
}
