import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class EvidenceZamestnancu {
    public static final ArrayList<Zamestanec> zamestnanci = new ArrayList<>();

    public EvidenceZamestnancu(){

    }

    public Zamestanec getZamestnanec(int index) {
        return zamestnanci.get(index);
    }

    public void readFromFile(File selectedFile) {
        try (
                FileReader fileReader = new FileReader(selectedFile);
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                Scanner scanner = new Scanner(bufferedReader);
        )
        {
            while (scanner.hasNextLine()){
                String radek = scanner.nextLine();
                String pole[] = radek.split(":");
                String jmeno = pole[0];
                String prijmeni = pole[1];
                boolean pojisteni = Boolean.parseBoolean(String.valueOf(pole[2].equals("ano")));
                LocalDate narozeni = LocalDate.parse(pole[3]);
                Zamestanec zamestanec = new Zamestanec(jmeno, prijmeni, pojisteni, narozeni);
                zamestnanci.add(zamestanec);
            }
        }
        catch (FileNotFoundException e){
            throw new RuntimeException(e);
        }
        catch (IOException e){
            throw new RuntimeException(e);
        }
    }

}
