package ua.com.foxminded.formula;

import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;


public class RacerBuilder {
    public List<Racer> createRacers(List<String>startDate, List<String>endDate, List<String>abbreviationDate){
        isNull(startDate,endDate,abbreviationDate);
        isEmpty(startDate,endDate,abbreviationDate);
        isSameSize(startDate,endDate,abbreviationDate);

        Map<String,String>startTimeMap = mappingTime(startDate);
        Map<String,String>endTimeMap = mappingTime(endDate);


        List<Racer>result = new LinkedList<>();
        String abbreviation;
        String name;
        String team;
        Duration lapTime;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss.SSS");


        for(int i =0;i < startDate.size();i++){
            abbreviation = abbreviationDate.get(i).split("_")[0];
            name = abbreviationDate.get(i).split("_")[1];
            team = abbreviationDate.get(i).split("_")[2];

            LocalTime startTime = LocalTime.parse(startTimeMap.get(abbreviation),formatter);
            LocalTime endTime = LocalTime.parse(endTimeMap.get(abbreviation),formatter);
            lapTime = Duration.between(startTime,endTime);

            Racer racerBuilder = new Racer(name,team,lapTime);
            result.add(racerBuilder);
        }
        return result;
    }


    private Map<String,String> mappingTime(List<String>inputDate){
            Map<String,String>result = new HashMap<>();
         inputDate.stream()
                .forEach(line->{
                   String[] strings = line.split("_");
                   String abr = strings[0].substring(0,3);
                   String time = strings[1];
                   result.put(abr,time);
                });

            return result;
    }

    private void isNull(List<String>start, List<String>end, List<String>abbreviation){
        Optional.ofNullable(start).orElseThrow(()->new IllegalArgumentException("null in start"));
        Optional.ofNullable(end).orElseThrow(()->new IllegalArgumentException("null in end"));
        Optional.ofNullable(abbreviation).orElseThrow(()->new IllegalArgumentException("null in abbreviation"));
    }

    private void isEmpty(List<String>start, List<String>end, List<String>abbreviation){
        if(start.isEmpty())
            throw new IllegalArgumentException("start is empty");
        if(end.isEmpty())
            throw new IllegalArgumentException("end is empty");
        if(abbreviation.isEmpty())
            throw new IllegalArgumentException("abbreviation is empty");

    }
    private void isSameSize(List<String>start, List<String>end, List<String>abbreviation){
        int startSize = start.size();
        int endSize = end.size();
        int abbreviationSize = abbreviation.size();
        if(startSize!=endSize||startSize!=abbreviationSize)
            throw new IndexOutOfBoundsException("Different in size arg");

    }

}
