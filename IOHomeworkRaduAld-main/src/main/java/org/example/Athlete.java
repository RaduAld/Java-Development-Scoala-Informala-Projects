package org.example;

/**
 num = number of the athlete
 name = name of the athlete
 countryCode = short form of the country of provenience
 minutes = the minutes of the skiing session
 seconds = the seconds of the skiing session
 firstShootingRange, secondShootingRange, thirdShootingRange = the results of the shooting ranges.
 **/
public class Athlete  implements Comparable {
    private int num;
    private String name;
    private String countryCode;
    private int minutes;
    private int seconds;
    private String firstShootingRange;
    private String secondShootingRange;
    private String thirdShootingRange;

    public String getTotalTime() {
        int nb = 0;
        for (int i = 0; i < 5; i++) {
            if (firstShootingRange.charAt(i) == 'o') {
                nb++;
            }
            if (secondShootingRange.charAt(i) == 'o') {
                nb++;
            }
            if (thirdShootingRange.charAt(i) == 'o') {
                nb++;
            }
        }
        int newSecs = seconds + nb * 10;
        return minutes + newSecs / 60 + ":" + newSecs % 60;
    }


    @Override
    public int compareTo(Object o1) {
        Athlete a2 = (Athlete)o1;

        String[] x = new String[2];
        x = this.getTotalTime().split(":");
        String[] y = new String[2];
        y = a2.getTotalTime().split(":");

        if (Integer.parseInt(x[0]) < Integer.parseInt(y[0])){
            return -1;
        } else if (Integer.parseInt(x[0]) > Integer.parseInt(y[0])){
            return 1;
        } else {
            return Integer.compare(Integer.parseInt(x[1]), Integer.parseInt(y[1]));
        }
    }

    @Override
    public String toString() {
        return  num + ". " + name + " (" + countryCode + "): " + this.getTotalTime() +
                " (from " + minutes + ':' + seconds + ")";
    }

    public Athlete(int num, String name, String countryCode,
                   int minutes, int seconds, String firstShootingRange,
                   String secondShootingRange, String thirdShootingRange) {
        this.num = num;
        this.name = name;
        this.countryCode = countryCode;
        this.minutes = minutes;
        this.seconds = seconds;
        this.firstShootingRange = firstShootingRange;
        this.secondShootingRange = secondShootingRange;
        this.thirdShootingRange = thirdShootingRange;
    }

}
