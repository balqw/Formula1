package ua.com.foxminded.formula;

import org.apache.commons.lang3.StringUtils;

import java.time.Duration;
import java.time.LocalTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class RacerFormatter {



    public String format(List<Racer> racerList) {

        List<Racer> racers = Optional.ofNullable(racerList)
                .orElseThrow(() -> new IllegalArgumentException("Racers non null arf required!"));

        final int lineForUnderLine = 15;
        int nameMaxLength = 0;
        int teamMaxLength = 0;
        int maxLengthLine;
        StringBuilder result = new StringBuilder();
        String lapTime;
        String underLine = "_";
        Collections.sort(racers);

        for (Racer racer : racers) {
            checkForNull(racer.getName(),racer.getTeam(),racer.getLapTime());
            if (racer.getName().length() > nameMaxLength)
                nameMaxLength = racer.getName().length();
            if (racer.getTeam().length() > teamMaxLength)
                teamMaxLength = racer.getTeam().length();
        }
        maxLengthLine = nameMaxLength + teamMaxLength + racerList.size();

        for (int i = 0; i < racers.size(); i++) {
            checkForNull(racers.get(i).getName(),racers.get(i).getTeam(),racers.get(i).getLapTime());
            lapTime = LocalTime.ofNanoOfDay(racers.get(i).getLapTime().toNanos()).toString();

            if (i == lineForUnderLine) {
                result.append(StringUtils.repeat(underLine, maxLengthLine)).append("\n");
            }
            result.append(String.format("%2d.%-" + nameMaxLength + "s%" +
                            "s%-" + teamMaxLength + "s%s%" +
                            "s%n",
                    i + 1, racers.get(i).getName(), "|", racers.get(i).getTeam(), "|", lapTime));
        }
        return result.toString();

    }


    private void checkForNull (String name, String team, Duration lapTime){
        Optional.ofNullable(name).orElseThrow(()->new IllegalArgumentException("null in name"));
        Optional.ofNullable(team).orElseThrow(()->new IllegalArgumentException("null in team"));
        Optional.ofNullable(lapTime).orElseThrow(()->new IllegalArgumentException("null in lapTime"));
    }

    Object object = new Object();
}
