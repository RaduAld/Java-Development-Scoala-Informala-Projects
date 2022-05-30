package org.example;

import java.util.ArrayList;
import java.util.List;

public class SkiBiathlon {
    List<Athlete> athletes = new ArrayList<>();

    public String addAthlete(Athlete athlete) {
        this.athletes.add(athlete);
        return athlete.toString();
    }

    public List<Athlete> getTop() {
        athletes.sort(new AthleteComparator<Athlete>());
        List<Athlete> result = new ArrayList<>();
        result.add(athletes.get(0));
        result.add(athletes.get(1));
        result.add(athletes.get(2));
        return result;
    }

}
