package org.example;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class ComparatorTest {

    static public boolean assertEqualsSkiTop(List<Athlete> expected, List<Athlete> actual) {
        for (int i = 0; i < 3; i++){
            if (expected.get(i).compareTo(actual.get(i)) != 0){
                return false;
            }
        }
        return true;
    }

    @Test
    public void Test1() {
        List<Athlete> athletes = new ArrayList<>(Arrays.asList(
                new Athlete(89, "Mary Jane", "UK", 21, 15,
                        "xooxo", "oxxxo", "xxoox"),
                new Athlete(47, "Anita Johnson", "DE", 24, 36,
                        "xoxox", "oxxoo", "xoxxx"),
                new Athlete(36, "Uma Dawn", "CA", 22, 12,
                        "xxooo", "oxxoo", "xoxox"),
                new Athlete(76, "Nelly Robinson", "FR", 18, 15,
                        "xoxxx", "xooxx", "xxoxx"),
                new Athlete(25, "Amy Fredrick", "RO", 21, 15,
                        "xxxxo", "oxxxx", "xxxox")
        ));
        SkiBiathlon skiBiathlon = new SkiBiathlon();
        for (Athlete a : athletes) {
            skiBiathlon.addAthlete(a);
        }

        List<Athlete> results = new ArrayList<>(Arrays.asList(
                athletes.get(3), athletes.get(4), athletes.get(0)
                ));

        Assert.assertTrue(assertEqualsSkiTop(skiBiathlon.getTop(), results));


    }

    @Test
    public void Test2() {
        List<Athlete> athletes = new ArrayList<>(Arrays.asList(
                new Athlete(88, "John Lennon", "IE", 27, 10,
                        "xxxxx", "xoxxx", "xxxxx"), //nb3
                new Athlete(34, "Freddie Mercury", "UK", 25, 14,
                        "xxxxo", "xxxxx", "xoxxx"), //nb2
                new Athlete(51, "Pink Floyd", "BG", 25, 26,
                        "oxooo", "oxooo", "xoooo"),
                new Athlete(62, "Neil Armstrong", "DK", 26, 45,
                        "xooxo", "ooooo", "xooxx"),
                new Athlete(11, "Morgan Freeman", "US", 23, 30,
                        "xxxxo", "oxxxx", "xxxox")  //nb1
        ));
        SkiBiathlon skiBiathlon = new SkiBiathlon();
        for (Athlete a : athletes) {
            skiBiathlon.addAthlete(a);
        }
        System.out.println(skiBiathlon.getTop());

        List<Athlete> results = new ArrayList<>(Arrays.asList(
                athletes.get(4), athletes.get(1),athletes.get(0)
        ));

        System.out.println(results);
        Assert.assertTrue(assertEqualsSkiTop(skiBiathlon.getTop(), results));


    }
}
