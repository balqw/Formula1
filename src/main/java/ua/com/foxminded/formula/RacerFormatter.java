package ua.com.foxminded.formula;

import org.apache.commons.lang3.StringUtils;

import java.time.LocalTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class RacerFormatter {

    public String format(List<Racer> racerList) {
        List<Racer> racers = Optional.ofNullable(racerList)
                .orElseThrow(() -> new IllegalArgumentException("Racers non null arf required!"));

        int nameMaxLength = 0;
        int teamMaxLength = 0;
        int maxLengthLine;
        int otherSymbols = 17;
        StringBuilder result = new StringBuilder();
        String lapTime;
        String underLine = "_";
        Collections.sort(racers);

        for (Racer racer : racers) {
            if (racer.getName().length() > nameMaxLength)
                nameMaxLength = racer.getName().length();
            if (racer.getTeam().length() > teamMaxLength)
                teamMaxLength = racer.getTeam().length();
        }
        maxLengthLine = nameMaxLength + teamMaxLength + otherSymbols;

        for (int i = 0; i < racers.size(); i++) {
            lapTime = LocalTime.ofNanoOfDay(racers.get(i).getLapTime().toNanos()).toString(); //FixMe: NPE here!

            if (i == 15) {
                System.out.println(StringUtils.repeat(underLine, maxLengthLine));
            }
            result.append(String.format("%2d.%-" + nameMaxLength + "s%" +
                            "s%-" + teamMaxLength + "s%s%" +
                            "s%n",
                    i + 1, racers.get(i).getName(), "|", racers.get(i).getTeam(), "|", lapTime));
        }
        return result.toString();

    }
}
