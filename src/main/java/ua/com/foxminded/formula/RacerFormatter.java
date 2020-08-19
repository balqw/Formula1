package ua.com.foxminded.formula;

import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.Collections;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
public class RacerFormatter {

    public String format(List<Racer> source){

        int nameMaxLength=0;
        int teamMaxLength=0;
        int maxLengthLine;
        int otherSymbols=17;
        StringBuilder result = new StringBuilder();
        String lapTime;
        String underLine = "_";
        Collections.sort(source);

        for(Racer racer : source){
            if(racer.getName().length()>nameMaxLength)
                nameMaxLength=racer.getName().length();
            if(racer.getTeam().length()>teamMaxLength)
                teamMaxLength=racer.getTeam().length();
        }
        maxLengthLine = nameMaxLength+teamMaxLength+otherSymbols;

        try {
            for (int i = 0;i <source.size();i++){
                lapTime = LocalTime.ofNanoOfDay(source.get(i).getLapTime().toNanos()).toString();

                if(i==15)
                {
                    System.out.println( StringUtils.repeat(underLine,maxLengthLine));
                }
                result.append(String.format("%2d.%-"+nameMaxLength+"s%" +
                        "s%-"+teamMaxLength+"s%s%" +
                        "s%n",
                        i+1,source.get(i).getName(),"|",source.get(i).getTeam(),"|",lapTime));
            }
        } catch (DateTimeParseException e) {
            System.out.println("error");
        }


        return result.toString();

    }
}
