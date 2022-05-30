package org.example;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collection;
import java.util.List;

public class App {
    public static void main(String[] args) throws IOException {
        System.out.println("Hello World!");

        SkiBiathlon skiBiathlon = new SkiBiathlon();

        String fs = File.separator;
        BufferedReader file = new BufferedReader(new FileReader(fs + "Users" + fs + "Admins" + fs +
                "Documents" + fs + "Radu" + fs + "It" + fs + "IOHomeworkRaduAld" + fs + "src" + fs + "main" + fs
                + "resources" + fs + "data.csv"));
        String row;
        while ((row = file.readLine()) != null) {
            String[] data = row.split(",");
            String[] t = data[3].split(":");
            Athlete athlete = new Athlete(Integer.parseInt(data[0]), data[1], data[2], Integer.parseInt(t[0]), Integer.parseInt(t[1]),
                    data[4], data[5], data[6]);
            System.out.println(skiBiathlon.addAthlete(athlete));
        }
        System.out.println();
        List<Athlete> top= skiBiathlon.getTop();
        System.out.println("Winner: " + top.get(0));
        System.out.println("Runner-up: " + top.get(1));
        System.out.println("Third Place: " + top.get(2));
    }
}
