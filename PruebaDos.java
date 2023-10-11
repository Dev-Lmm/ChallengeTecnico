import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 *Using first_names.txt (text file containing over five-thousand first names), begin by sorting it into alphabetical order. Then workout the alphabetical value for each name, multiply this value by its alphabetical position to obtain a name score.
 *
 * Example: assuming sorted and COLIN to be the 938th name it is worth: 3+15+12+9+14. So, the score would be 938*53 = 49,714.
 *
 * What is the total of all the name scores in the file?
 *
 * */
public class PruebaDos {
    public static void main(String[] args) {
        try {
            long totalScore = 0;
            Scanner scanner = new Scanner(new File("C:\\Users\\gordi\\OneDrive\\Documentos\\prueba\\first_names.txt"));
            List<String> names = new ArrayList<>();

            while (scanner.hasNext()) {
                String name = scanner.next();
                String[] parts = name.split(",");
                for (String part : parts){
                    names.add(part.replaceAll("\"", ""));
                }
            }

            Collections.sort(names);

            System.out.println("Nombres ordenados:" + names);


            for (int i = 0; i < names.size();  i++) {
                String name = names.get(i);
                int nameScore = 0;

                for (char c : name.toCharArray()) {
                    nameScore += c - 'A' + 1;
                }

                totalScore += (long) (i + 1) * nameScore;
            }

            System.out.println("El puntaje total de todos los nombres es: " + totalScore);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
