package org.example;

import java.util.Comparator;

public class AthleteComparator<A> implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        Athlete a1 = (Athlete)o1;
        Athlete a2 = (Athlete)o2;
        return a1.compareTo(a2);
    }
}
