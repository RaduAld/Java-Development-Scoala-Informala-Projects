import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Writer {

    public static void writeFile(ArrayList<Person> personList) throws IOException {
        String fs = File.separator;
        File file = new File(fs + "Users" + fs + "Admins" + fs +
                "Documents" + fs + "Radu" + fs + "It" + fs + "java-8HomeworkRaduAld" + fs + "src" + fs + "main" + fs
                + "resources" + fs + "results.csv");
        FileWriter fw = new FileWriter(file);
        BufferedWriter bw = new BufferedWriter(fw);

        personList.forEach(p -> {
            try {
                bw.write(p.getFirstName() + ',' + p.getLastName() + ',' + p.getDob());
                bw.newLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        bw.close();
        fw.close();
    }

}
