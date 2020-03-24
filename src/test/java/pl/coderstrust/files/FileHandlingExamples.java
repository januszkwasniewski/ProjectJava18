package pl.coderstrust.files;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class FileHandlingExamples {


    // Bardzo dobra metoda na czytanie plików pod warunkiem, że są to pliki tekstowe.
    void scanner() {
        File file = new File("src/test/resources/test.txt");
        try (Scanner scanner = new Scanner(file)) {

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }

        } catch (Exception e) {
            System.out.println("Cos poszlo nie tak" + e.getMessage());
        }


    }


    // Czasem mamy plik przekazywany z jakiejś innej metody w postaci InputStream.
    // To znaczy, że może być to każdy rodzaj pliku, nie tylko tekstowy.
    @Test
    void inputStream() throws IOException {
        File file = new File("src/test/resources/test.txt");

        FileInputStream inputStream = new FileInputStream(file);


        byte[] bytes = new byte[100];
        inputStream.read(bytes);

        // W ten sposob mamy tablice bytow, czyli zakodowany tekst binarnie:
        System.out.println(Arrays.toString(bytes));

        // Jak chcemy odkodować, musimy "zrzutować" kod na typ znakowy (char)
        System.out.println((char) bytes[0]);

        inputStream.close();
    }


    // Kolejna warstwa pozwalająca usprawnić odczyt (używająca mechanizmu bufforowania).
    // Java BufferedInputStream class is used to read information from stream. It internally uses buffer mechanism to make the performance fast.
    // = szybciej trochę niż sam FileInputStream.
    @Test
    void bufferedInputStream() throws IOException {
        File file = new File("src/test/resources/test.txt");

        FileInputStream inputStream = new FileInputStream(file);

        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);


        byte[] bytes = bufferedInputStream.readAllBytes();

        System.out.println(Arrays.toString(bytes));

        bufferedInputStream.close();
    }


    // Kosztowne, ale pozwala już na odczytanie pliku jako tablice charów
    // (FileReader to jest kolejna warstwa cebuli, tylko do plików tekstowych)
    @Test
    void fileReader() throws IOException {
        File file = new File("src/test/resources/test.txt");
        FileReader fileReader = new FileReader(file);

        char[] table = new char[100];
        fileReader.read(table);

        System.out.println(table);

        fileReader.close();
    }


    // Czytanie plików linia po linii, od razu do stringa zamiast do byte array - wrapper na FileReader, czyli już lepiej. I szybciej, bo buforuje.
    @Test
    void bufferedReader() throws IOException {
        File file = new File("src/test/resources/test.txt");

        FileReader reader = new FileReader(file);

        BufferedReader bufferedReader = new BufferedReader(reader);

        String line = bufferedReader.readLine();

        while (line != null) {
            System.out.println(line);
            line = bufferedReader.readLine();
        }

        reader.close();
        bufferedReader.close();
    }

    @Test
    void files() throws IOException {
        List<String> lines = Files.readAllLines(Paths.get("src/test/resources/test.txt"));

        for (String line : lines) {
            System.out.println(line);

        }
    }


    // Zapisywanie do pliku uzywajac BufferedWritera
    @Test
    void saveToFile() throws IOException {
        File file = new File("src/test/resources/test.txt");

        FileWriter fileWriter = new FileWriter(file);

        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

        String textToWrite = "Testowy tekst";

        bufferedWriter.write(textToWrite);

        bufferedWriter.newLine();

        bufferedWriter.flush();
        bufferedWriter.close();

    }
}